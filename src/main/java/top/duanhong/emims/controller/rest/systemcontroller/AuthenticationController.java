package top.duanhong.emims.controller.rest.systemcontroller;

import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import top.duanhong.emims.configuration.securityconfig.SecurityPropertise;
import top.duanhong.emims.pojo.tools.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author duanhong
 * @description 认证
 * @date 2019/4/17
 */
@Api("登录验证")
@RestController
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class AuthenticationController {

    @Autowired
    private SecurityPropertise securityPropertise;

    private Logger log= LogFactory.getLogger(AuthenticationController.class);

    private RequestCache requestCache=new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();

    /**
     * 没有认证的处理接口，如果没有认证可以处理成为返回提示信息或者跳转至配置的登录页面
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/authentication/require",produces = "text/plain;charset=utf-8")
    public void loginAuth(HttpServletRequest request, HttpServletResponse response)throws IOException {
        SavedRequest savedRequest=requestCache.getRequest(request,response);
        if (savedRequest!=null){
            String tartgetUrl=savedRequest.getRedirectUrl();
            log.info("收到请求:"+tartgetUrl);
            if (tartgetUrl.indexOf("error")>-1){
                redirectStrategy.sendRedirect(request,response,securityPropertise.getBrowser().getErrorPage());
            }else {
                redirectStrategy.sendRedirect(request,response,securityPropertise.getBrowser().getLoginPage());
            }
            /*if (StringUtils.endsWithIgnoreCase(tartgetUrl,".html")){
            }*/
        }
//        return "访问的服务需要身份认证。请引导用户到登录页";

    }
}
