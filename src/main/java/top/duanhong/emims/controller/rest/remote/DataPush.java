package top.duanhong.emims.controller.rest.remote;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanhong
 * @description 数据推送
 * @date 2019/5/11
 */
@RestController
@RequestMapping("/api")
public class DataPush {

    @RequestMapping("/dataPush/{cId}")
    public RequestEntity dataPush(@PathVariable String cId,String message){
//        WebSocketServer.sendInfo();
        return null;
    }
}
