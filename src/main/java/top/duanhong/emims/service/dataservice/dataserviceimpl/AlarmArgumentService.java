package top.duanhong.emims.service.dataservice.dataserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.duanhong.emims.dao.datadao.AlarmArgumentRepository;
import top.duanhong.emims.pojo.dto.response.MethodExecuteResult;
import top.duanhong.emims.pojo.po.AlarmArgument;

import java.util.Optional;

/**
 * @author duanhong
 * @description 预警参数设置
 * @date 2019/5/16
 */
@Service
public class AlarmArgumentService {
    @Autowired
    private AlarmArgumentRepository alarmArgumentRepository;

    public AlarmArgument getAlarmArgument() {
        Optional<AlarmArgument> alarmArgumentOptional=alarmArgumentRepository.findById(1L);
        return alarmArgumentOptional.get();
    }

    public AlarmArgument saveAlarmArgument(AlarmArgument alarmArgument) {
        return alarmArgumentRepository.save(alarmArgument);
    }

    public MethodExecuteResult getAlarmArguments(String deviceMac) {
        MethodExecuteResult methodExecuteResult=new MethodExecuteResult();
        AlarmArgument alarmArgumentResult=alarmArgumentRepository.findByDeviceMac(deviceMac);
        if (alarmArgumentResult!=null){
            methodExecuteResult.setMessage("获取成功");
            methodExecuteResult.setData(alarmArgumentResult);
        }else {
            methodExecuteResult.setMessage("该检测仪尚未设置参数");
            methodExecuteResult.setData(null);
        }
        methodExecuteResult.setSuccess(true);
        return methodExecuteResult;
    }

    public MethodExecuteResult updateAlarmArgument(AlarmArgument alarmArgument) {
        MethodExecuteResult methodExecuteResult=new MethodExecuteResult();
        AlarmArgument alarmArgumentResult=new AlarmArgument();
        AlarmArgument alarmArgu=alarmArgumentRepository.findByDeviceMac(alarmArgument.getDeviceMac());
        if (alarmArgu!=null){
            alarmArgumentResult.setArgumentId(alarmArgu.getArgumentId());
            alarmArgumentResult.setMaxT(alarmArgument.getMaxT());
            alarmArgumentResult.setMinT(alarmArgument.getMinT());
            alarmArgumentResult.setMaxHumi(alarmArgument.getMaxHumi());
            alarmArgumentResult.setMinHumi(alarmArgument.getMinHumi());
            alarmArgumentResult.setMaxUltra(alarmArgument.getMaxUltra());
            alarmArgumentResult.setMinUltra(alarmArgument.getMinUltra());
            alarmArgumentResult.setMaxIllum(alarmArgument.getMaxIllum());
            alarmArgumentResult.setMinIllum(alarmArgument.getMinIllum());
            alarmArgumentResult.setMaxPm(alarmArgument.getMaxPm());
            alarmArgumentResult.setMinAirP(alarmArgument.getMinAirP());
            alarmArgumentResult.setDeviceMac(alarmArgument.getDeviceMac());
            alarmArgumentRepository.save(alarmArgumentResult);
            methodExecuteResult.setSuccess(true);
            methodExecuteResult.setMessage("修改成功");
            methodExecuteResult.setData(alarmArgumentRepository.findById(alarmArgument.getArgumentId()));
        }else {
            alarmArgumentResult.setMaxT(alarmArgument.getMaxT());
            alarmArgumentResult.setMinT(alarmArgument.getMinT());
            alarmArgumentResult.setMaxHumi(alarmArgument.getMaxHumi());
            alarmArgumentResult.setMinHumi(alarmArgument.getMinHumi());
            alarmArgumentResult.setMaxUltra(alarmArgument.getMaxUltra());
            alarmArgumentResult.setMinUltra(alarmArgument.getMinUltra());
            alarmArgumentResult.setMaxIllum(alarmArgument.getMaxIllum());
            alarmArgumentResult.setMinIllum(alarmArgument.getMinIllum());
            alarmArgumentResult.setMaxPm(alarmArgument.getMaxPm());
            alarmArgumentResult.setMinAirP(alarmArgument.getMinAirP());
            alarmArgumentResult.setDeviceMac(alarmArgument.getDeviceMac());
            alarmArgumentRepository.save(alarmArgumentResult);
            methodExecuteResult.setSuccess(true);
            methodExecuteResult.setMessage("新增设备参数设置成功");
        }

        return methodExecuteResult;
    }
}
