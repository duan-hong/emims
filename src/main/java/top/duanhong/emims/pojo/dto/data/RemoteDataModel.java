package top.duanhong.emims.pojo.dto.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import top.duanhong.emims.pojo.po.RemoteData;

import java.util.Date;

/**
 * @author duanhong
 * @description 远程数据
 * @date 2019/5/5
 */
public class RemoteDataModel {
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

    public RemoteData getRemoteDatePo(){
        RemoteData remoteData=new RemoteData();
        remoteData.setTemp(this.temp);
        remoteData.setHumi(this.humi);
        remoteData.setAirP(this.airP);
        remoteData.setPm(this.pm);
        remoteData.setUltra(this.ultra);
        remoteData.setIllum(this.illum);
        remoteData.setLongtitude(this.longtitude);
        remoteData.setLatitude(this.latitude);
        remoteData.setAltitude(this.altitude);
        remoteData.setDeviceId(this.deviceId);
        remoteData.setReceiveDate(new Date());
        return remoteData;
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
}
