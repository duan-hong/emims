package top.duanhong.emims.service.dataservice.remotedatahandle;
import top.duanhong.emims.controller.utils.JsonUtil;
import top.duanhong.emims.pojo.dto.data.RemoteDataModel;
import top.duanhong.emims.pojo.po.RemoteData;
import top.duanhong.emims.service.utils.SpringUtil;

/**
 * @author duanhong
 * @description 远程数据处理
 * @date 2019/5/11
 */
public class RemoteDataHandleService {

    private static RemoteDataService remoteDataService=SpringUtil.getBean(RemoteDataService.class);

    public static void acceptRemoteData(String dataStr){
        if (dataStr!=null&&!"".equals(dataStr)){
            RemoteDataModel remoteDataModel=JsonUtil.fromJsonStr(dataStr);
            if (remoteDataModel!=null){
                //存储数据
                RemoteData remoteData=remoteDataService.saveRemoteData(remoteDataModel.getRemoteDatePo());
                //监听数据，判断是否发起预警通知
                DataMonitor.isPushAlarm(remoteData);
                //推送实时数据
                DataPushService.dataPush(remoteData,null);
            }
        }
    }
}
