/*
package top.duanhong.emims.controller.rest.systemcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.duanhong.emims.service.userservice.YzmService;

import javax.servlet.http.HttpSession;

*/
/**
 * 验证码处理
 * @author Administrator
 *//*

@Controller
@RequestMapping("sysAdmin")
public class YzmController {
    @Autowired
    private YzmService yzmService;

    @RequestMapping("/regist/sendYzm")
    @ResponseBody
    public String sendYzm(String mailAddress, HttpSession httpSession){
        String yzm=Math.random()+"";
        yzm=yzm.substring(2,8);
        httpSession.setAttribute("registYzm",yzm);
        String result=yzmService.sendYzm(mailAddress,yzm);
        return result;
    }
}
*/
