package top.duanhong.emims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import top.duanhong.emims.service.dataservice.remotedatahandle.SocketServer;

/**
 * EnableCaching开启缓存
 * emims入口
 * Spring Boot 2.2.0升级到2.2.1的话，这里要特别注意有用到@ConfigurationProperties注解的地方。
 *
 * 在2.2.1中，该注解的扫描支持默认不启用了，用户需要自己通过添加@ConfigurationPropertiesScan注解，显式地去扫描以完成初始化动作。
 */
@SpringBootApplication
@EnableCaching
@EnableSwagger2
@EnableEurekaClient
@ConfigurationPropertiesScan
public class EmimsEntry {
    public static void main(String[] args) {
        SpringApplication.run(EmimsEntry.class,args);
        //起socket服务
        SocketServer socketServer=new SocketServer();
        socketServer.startSocketServer();
    }
}
