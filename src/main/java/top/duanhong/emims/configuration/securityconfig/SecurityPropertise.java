package top.duanhong.emims.configuration.securityconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author duanhong
 * @description 从配置文件进行安全设置
 * @date 2019/4/17
 */
@ConfigurationProperties(prefix = "emims.security")
public class SecurityPropertise {

    private BrowserPropertise browser=new BrowserPropertise();

    public BrowserPropertise getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserPropertise browser) {
        this.browser = browser;
    }
}
