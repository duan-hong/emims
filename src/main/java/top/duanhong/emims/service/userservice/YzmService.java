package top.duanhong.emims.service.userservice;

/**
 * 验证码
 * @author Administrator
 */
public interface YzmService {
    /**
     * 发送验证码
     * @param mailAddress
     * @param yzm
     * @return
     */
    String sendYzm(String mailAddress, String yzm);
}

