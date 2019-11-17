package top.duanhong.emims.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
@Entity
@Table(name = "tbl_temp")
public class Temp implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tempId;
    private float temperature;
    private float longtitude;
    private float latitude;
    private float altitude;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date saveTime;
    private String deviceId;


    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Temp{" +
                "tem_id='" + tempId + '\'' +
                ", temperature=" + temperature +
                ", longtitude=" + longtitude +
                ", latitude=" + latitude +
                ", altitude=" + altitude +
                ", location='" + location + '\'' +
                ", save_time='" + saveTime + '\'' +
                ", device_id='" + deviceId + '\'' +
                '}';
    }
}
