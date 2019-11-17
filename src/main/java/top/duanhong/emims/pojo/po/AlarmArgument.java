package top.duanhong.emims.pojo.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author duanhong
 * @description 预警参数
 * @date 2019/5/16
 */
@Entity
@Table(name = "tbl_alarm_argument")
public class AlarmArgument implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long argumentId;
    private float maxT;
    private float minT;
    private float maxHumi;
    private float minHumi;
    private float maxIllum;
    private float minIllum;
    private float maxUltra;
    private float minUltra;
    private float maxPm;
    private float minAirP;
    private String deviceMac;

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public long getArgumentId() {
        return argumentId;
    }

    public void setArgumentId(long argumentId) {
        this.argumentId = argumentId;
    }

    public float getMaxT() {
        return maxT;
    }

    public void setMaxT(float maxT) {
        this.maxT = maxT;
    }

    public float getMinT() {
        return minT;
    }

    public void setMinT(float minT) {
        this.minT = minT;
    }

    public float getMaxHumi() {
        return maxHumi;
    }

    public void setMaxHumi(float maxHumi) {
        this.maxHumi = maxHumi;
    }

    public float getMinHumi() {
        return minHumi;
    }

    public void setMinHumi(float minHumi) {
        this.minHumi = minHumi;
    }

    public float getMaxIllum() {
        return maxIllum;
    }

    public void setMaxIllum(float maxIllum) {
        this.maxIllum = maxIllum;
    }

    public float getMinIllum() {
        return minIllum;
    }

    public void setMinIllum(float minIllum) {
        this.minIllum = minIllum;
    }

    public float getMaxUltra() {
        return maxUltra;
    }

    public void setMaxUltra(float maxUltra) {
        this.maxUltra = maxUltra;
    }

    public float getMinUltra() {
        return minUltra;
    }

    public void setMinUltra(float minUltra) {
        this.minUltra = minUltra;
    }

    public float getMaxPm() {
        return maxPm;
    }

    public void setMaxPm(float maxPm) {
        this.maxPm = maxPm;
    }

    public float getMinAirP() {
        return minAirP;
    }

    public void setMinAirP(float minAirP) {
        this.minAirP = minAirP;
    }


}
