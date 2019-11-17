package top.duanhong.emims.configuration.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import top.duanhong.emims.configuration.securityconfig.LoginType;
import top.duanhong.emims.configuration.securityconfig.SecurityPropertise;
import top.duanhong.emims.controller.utils.ResponseFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author duanhong
 * @description 认证失败处理
 * @date 2019/4/17
 */
@Component("emimsAuthenticationFailHandler")
public class EmimsAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityPropertise securityPropertise;
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if (LoginType.JSON.equals(securityPropertise.getBrowser().getLoginType())){
//            httpServletResponse.setStatus(HttpStatus.OK.value());
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            Map<String,String> map=new HashMap<>();
            if (e instanceof LockedException) {
                map.put("msg", "账户被锁定");
            } else if (e instanceof BadCredentialsException) {
                map.put("msg", "账号或者密码错误，登录失败");
            } else if (e instanceof DisabledException) {
                map.put("msg", "账号被禁用登录失败");
            } else if (e instanceof AccountExpiredException) {
                map.put("msg", "账号过期，登录失败");
            } else if (e instanceof CredentialsExpiredException) {
                map.put("msg", "密码过期，登录失败");
            } else {
                map.put("msg", "用户名不存在");
            }
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(new ResponseEntity<>(ResponseFactory.getBaseResponse("登录失败",map),HttpStatus.INTERNAL_SERVER_ERROR)));
        }else {
            super.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
        }
    }
}
