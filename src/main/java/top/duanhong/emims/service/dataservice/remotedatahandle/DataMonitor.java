package top.duanhong.emims.service.dataservice.remotedatahandle;

import top.duanhong.emims.pojo.po.AlarmArgument;
import top.duanhong.emims.pojo.po.RemoteData;
import top.duanhong.emims.service.dataservice.dataserviceimpl.AlarmArgumentService;
import top.duanhong.emims.service.utils.AlarmUtil;
import top.duanhong.emims.service.utils.SpringUtil;

/**
 * @author duanhong
 * @description 数据监听
 * @date 2019/5/14
 */
public class DataMonitor {
    private static AlarmArgumentService alarmArgumentService=SpringUtil.getBean(AlarmArgumentService.class);

    public static void isPushAlarm(RemoteData remoteData){
        //获取预警参数
        AlarmArgument alarmArgument=alarmArgumentService.getAlarmArgument();
        AlarmUtil.alarmArgumentJudge(alarmArgument,remoteData);
    }
}
