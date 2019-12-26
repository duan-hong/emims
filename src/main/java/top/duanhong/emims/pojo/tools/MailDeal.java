/*
package top.duanhong.emims.pojo.tools;

import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class MailDeal {
    */
/*
            odeizmbrhatbbbce
    jkfqiyclrcjxbfjf
            kqoiaxjccsnsbbcf*//*

    public static final String SMTPSERVER = "smtp.qq.com";
    public static final String SMTPPORT = "465";
    public static final String ACCOUT = "980528586@qq.com";
    public static final String PWD = "sdrrnnuimgkvbegb";

    public static  int sendMail(String address,String content){
        int result=1;
        try {
            testSendEmail(address,content);
        } catch (Exception e) {
            result=0;
        }
        return result;
    }

    public static  void testSendEmail(String adderss,String content) throws Exception {
        // 创建邮件配置
        Properties props = new Properties();
        // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", "smtp");
        // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.host", SMTPSERVER);
        props.setProperty("mail.smtp.port", SMTPPORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // 需要请求认证
        props.setProperty("mail.smtp.auth", "true");
        // 开启ssl
        props.setProperty("mail.smtp.ssl.enable", "true");


        // 根据邮件配置创建会话，注意session别导错包
        Session session = Session.getDefaultInstance(props);
        // 开启debug模式，可以看到更多详细的输入日志
        session.setDebug(true);
        //创建邮件
        MimeMessage message = createEmail(session,adderss,content);
        //获取传输通道
        Transport transport = session.getTransport();
        transport.connect(SMTPSERVER,ACCOUT, PWD);
        //连接，并发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }


    public static  MimeMessage createEmail(Session session,String address,String content) throws Exception {
        // 根据会话创建邮件
        MimeMessage msg = new MimeMessage(session);
        // address邮件地址, personal邮件昵称, charset编码方式
        InternetAddress fromAddress = new InternetAddress(ACCOUT, "【emims环境监测系统】", "utf-8");

        msg.setFrom(fromAddress);
        // 设置发送邮件方
        InternetAddress receiveAddress = new InternetAddress(address, "test", "utf-8");
        // 设置邮件接收方
        msg.setRecipient(Message.RecipientType.TO, receiveAddress);
        // 设置邮件标题
        msg.setSubject("验证码发送", "utf-8");
        String mess="您好，请输入该验证码["+content+"]，该验证码有效时长为一分钟";
        msg.setText(mess);
        // 设置显示的发件时间
        msg.setSentDate(new Date());
        // 保存设置
        msg.saveChanges();
        return msg;
    }
}
*/
