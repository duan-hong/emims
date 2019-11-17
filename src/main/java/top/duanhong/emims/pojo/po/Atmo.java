package top.duanhong.emims.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 大气压持久层对象
 * @author Administrator
 */
@Entity
@Table(name = "tbl_atmo_press")
public class Atmo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String atmoPressId;
    private float atom;
    private float longtitude;
    private float latitude;
    private float altitude;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date saveTime;
    private String deviceId;

    public String getAtmoPressId() {
        return atmoPressId;
    }

    public void setAtmoPressId(String atmoPressId) {
        this.atmoPressId = atmoPressId;
    }

    public float getAtom() {
        return atom;
    }

    public void setAtom(float atom) {
        this.atom = atom;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "Atmo{" +
                "atmoPressId='" + atmoPressId + '\'' +
                ", atom=" + atom +
                ", longtitude=" + longtitude +
                ", latitude=" + latitude +
                ", altitude=" + altitude +
                ", location='" + location + '\'' +
                ", saveTime=" + saveTime +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
