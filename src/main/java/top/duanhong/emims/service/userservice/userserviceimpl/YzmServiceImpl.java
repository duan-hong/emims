package top.duanhong.emims.service.userservice.userserviceimpl;
import org.springframework.stereotype.Service;
import top.duanhong.emims.pojo.tools.MailDeal;
import top.duanhong.emims.service.userservice.YzmService;

/**
 * 验证码业务层
 * @author Administrator
 */
@Service
public class YzmServiceImpl implements YzmService {

    @Override
    public String sendYzm(String mailAddress, String yzm) {
        //发送验证码
        int result= MailDeal.sendMail(mailAddress,yzm);
        return result+"";
    }

}
