package top.duanhong.emims.pojo.po;

import javax.persistence.*;

/**
 * @author duanhong
 * @description 监测设备
 * @date 2019/5/22
 */
@Entity
@Table(name = "tbl_monitor_device")
public class MonitorDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long deviceId;
    private String deviceMac;
    private String location;
    private String code;
    private String deviceInfo;


    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
