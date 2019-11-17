package top.duanhong.emims.pojo.dto.data;

import top.duanhong.emims.pojo.po.RemoteData;

import java.util.Date;

/**
 * @author duanhong
 * @description 预警信息
 * @date 2019/5/16
 */
public class AlarmMessage {
    private RemoteData remoteData;
    private String alarmType;
    private String alarmTitle;
    private Date alarmDate;

    public RemoteData getRemoteData() {
        return remoteData;
    }

    public void setRemoteData(RemoteData remoteData) {
        this.remoteData = remoteData;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmTitle() {
        return alarmTitle;
    }

    public void setAlarmTitle(String alarmTitle) {
        this.alarmTitle = alarmTitle;
    }

    public Date getAlarmDate() {
        return alarmDate;
    }

    public void setAlarmDate(Date alarmDate) {
        this.alarmDate = alarmDate;
    }
}
