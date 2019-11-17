package top.duanhong.emims.pojo.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 我们一般的实体类不需要程序员再次实现序列化的时候，请想两个问题：
 * 第一：存储媒体里面，是否是有其相对应的数据结构,没有对应的数据类型是需要？
 * 第二：这个实体类，是否需要远程传输（或者两个不同系统甚至是分布式模块之间的调用），远程时需要？
 * @author Administrator
 */
@Entity
@Table(name = "sys_users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String userPwd;
    private String headImg;
    private Date birthday;
    private String mail;
    private String tel;
    private int role;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userId=" + userId +
                ", UserPwd='" + userPwd + '\'' +
                ", headImg='" + headImg + '\'' +
                ", birthday=" + birthday +
                ", mail='" + mail + '\'' +
                ", tel='" + tel + '\'' +
                ", role=" + role +
                '}';
    }
}
