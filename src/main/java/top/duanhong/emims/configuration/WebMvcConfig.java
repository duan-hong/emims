package top.duanhong.emims.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.duanhong.emims.configuration.securityconfig.SecurityPropertise;

import java.util.List;

/**
 * @author duanhong
 * @description mvcConfig
 * @date 2019/4/6
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Autowired
    private SecurityPropertise securityPropertise;

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //默认登录页面index.html
        registry.addViewController("/index.html").setViewName("index");

        String loginPage = securityPropertise.getBrowser().getLoginPage();
        String pageName = loginPage.substring(1, loginPage.indexOf("."));
        //配置登录页面
        registry.addViewController(loginPage).setViewName(pageName);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // 注册Spring data jpa pageable的参数分解器
        argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
    }




}
