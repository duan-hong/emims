package top.duanhong.emims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import top.duanhong.emims.service.dataservice.remotedatahandle.SocketServer;

/**
 * EnableCaching开启缓存
 * emims入口
 * @author duanhong
 */
@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class EmimsEntry {
    public static void main(String[] args) {
        SpringApplication.run(EmimsEntry.class,args);
        //起socket服务
        SocketServer socketServer=new SocketServer();
        socketServer.startSocketServer();
    }
}
