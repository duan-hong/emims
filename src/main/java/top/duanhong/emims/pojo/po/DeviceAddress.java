package top.duanhong.emims.pojo.po;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

/**
 * @author duanhong
 * @description 设备地址
 * @date 2019/5/27
 */
@Table(name = "tbl_device_addr")
@Entity
public class DeviceAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String deviceId;
    private String deviceMac;
    private String loaction;
    private float longtitude;
    private float latitude;
    private float altitude;

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getLoaction() {
        return loaction;
    }

    public void setLoaction(String loaction) {
        this.loaction = loaction;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }
}
