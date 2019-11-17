package top.duanhong.emims.service.dataservice.remotedatahandle;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.log4j.Logger;
import top.duanhong.emims.controller.utils.JsonDateValueProcessor;
import top.duanhong.emims.pojo.dto.data.RemoteDataModel;
import top.duanhong.emims.pojo.po.RemoteData;
import top.duanhong.emims.pojo.tools.LogFactory;

import java.io.IOException;
import java.util.Date;

/**
 * @author duanhong
 * @description 数据推送
 * @date 2019/5/11
 */
public class DataPushService {
    static Logger log= LogFactory.getLogger(DataPushService.class);

    public static Boolean dataPush(RemoteData remoteData, String cId){
        Boolean isSuccess=true;
        try {
            JsonConfig jsonConfig=new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor("yy-MM-dd hh:mm:ss"));
            JSONObject jsonObject=JSONObject.fromObject(remoteData,jsonConfig);
            WebSocketServer.sendInfo(jsonObject.toString(),cId);
        } catch (IOException e) {
            isSuccess=false;
            log.error(e.getMessage());
        }
        return isSuccess;
    }
}
