package top.duanhong.emims.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import top.duanhong.emims.configuration.authentication.EmimsAuthentcationSuccessHandler;
import top.duanhong.emims.configuration.authentication.EmimsAuthenticationFailureHandler;
import top.duanhong.emims.configuration.securityconfig.SecurityPropertise;
import top.duanhong.emims.service.userservice.userserviceimpl.CustomUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author duanhong
 * @description spring-security配置
 * @date 2019/3/28
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityPropertise securityPropertise;
    @Autowired
    private EmimsAuthentcationSuccessHandler emimsAuthentcationSuccessHandler;
    @Autowired
    private EmimsAuthenticationFailureHandler emimsAuthenticationFailureHandler;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());
    }
    /**
     * 定义认证逻辑
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //没有认证的接口
                .loginPage("/authentication/require")
                .loginProcessingUrl("/login")
                .successHandler(emimsAuthentcationSuccessHandler)
                .failureHandler(emimsAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                //和认证相关的需要放行，否则会导致多重定向异常
                .antMatchers("/authentication/require",securityPropertise.getBrowser().getLoginPage())
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .headers().frameOptions().disable();
        http.csrf().disable();
    }


    /**
     * 开放静态资源，同时还要设置mvc的static路径
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**/*.js", "/lang/*/json", "/**/*.css", "/**/*.map", "/**/*.png", "/**/*.jpg", "/**/*.html");
    }
}
