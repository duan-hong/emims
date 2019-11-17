package top.duanhong.emims.pojo.dto.data;

import top.duanhong.emims.pojo.po.User;

import java.util.Date;

public class UserDto {

    private String userName;
    private String userPwd;
    private String headImg;
    private Date birthday;
    private String mail;
    private String tel;
    private User userPo;

    public User getUserPo() {
        userPo.setUserName(this.userName);
        userPo.setUserPwd(this.userPwd);
        userPo.setHeadImg(this.headImg);
        userPo.setBirthday(this.birthday);
        userPo.setMail(this.mail);
        userPo.setTel(this.tel);
        return userPo;
    }

    public void setUserPo(User userPo) {
        this.userPo = userPo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
