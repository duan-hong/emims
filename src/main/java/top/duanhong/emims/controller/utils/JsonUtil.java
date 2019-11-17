package top.duanhong.emims.controller.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import top.duanhong.emims.pojo.dto.data.RemoteDataModel;
import top.duanhong.emims.pojo.tools.LogFactory;

import java.io.IOException;

/**
 * @author duanhong
 * @description Json工具
 * @date 2019/5/5
 */
public class JsonUtil {
    public static RemoteDataModel fromJsonStr(String jsonStr) {
        Logger log= LogFactory.getLogger(JsonUtil.class);
        ObjectMapper objectMapper = new ObjectMapper();
        RemoteDataModel remoteDataModel = new RemoteDataModel();
        try {
            remoteDataModel = objectMapper.readValue(jsonStr, RemoteDataModel.class);
        } catch (IOException e) {
            log.error("远程数据转换异常，数据格式错误");
        }
        return remoteDataModel;
    }
}
