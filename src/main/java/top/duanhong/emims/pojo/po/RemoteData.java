package top.duanhong.emims.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author duanhong
 * @description 远程数据
 * @date 2019/5/5
 */
@Entity
@Table(name = "tbl_remote_data")
public class RemoteData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  dataId;
    private float temp;
    private float humi;
    private float airP;
    private float pm;
    private float ultra;
    private float illum;
    private float longtitude;
    private float altitude;
    private float latitude;
    private String deviceId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date receiveDate;

    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumi() {
        return humi;
    }

    public void setHumi(float humi) {
        this.humi = humi;
    }

    public float getAirP() {
        return airP;
    }

    public void setAirP(float airP) {
        this.airP = airP;
    }

    public float getPm() {
        return pm;
    }

    public void setPm(float pm) {
        this.pm = pm;
    }

    public float getUltra() {
        return ultra;
    }

    public void setUltra(float ultra) {
        this.ultra = ultra;
    }

    public float getIllum() {
        return illum;
    }

    public void setIllum(float illum) {
        this.illum = illum;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Override
    public String toString() {
        return "RemoteData{" +
                "dataId=" + dataId +
                ", temp=" + temp +
                ", humi=" + humi +
                ", airP=" + airP +
                ", pm=" + pm +
                ", ultra=" + ultra +
                ", illum=" + illum +
                ", longtitude=" + longtitude +
                ", altitude=" + altitude +
                ", latitude=" + latitude +
                ", deviceId='" + deviceId + '\'' +
                ", receiveDate=" + receiveDate +
                '}';
    }
}
