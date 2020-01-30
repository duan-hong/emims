package top.duanhong.emims.configuration.securityconfig;

/**
 * @author duanhong
 * @description 浏览器配置
 * @date 2019/4/17
 */
public class BrowserPropertise {
    /**
     * 默认登录页面
     */
    private String loginPage = "/index.html";
    private String errorPage="/404.html";

    /**
     * 默认登录方式
     */
    private LoginType loginType=LoginType.JSON;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }
}
