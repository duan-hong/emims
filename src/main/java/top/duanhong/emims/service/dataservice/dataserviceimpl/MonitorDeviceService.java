package top.duanhong.emims.service.dataservice.dataserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.duanhong.emims.dao.datadao.MonitorDeviceRepository;
import top.duanhong.emims.pojo.dto.response.MethodExecuteResult;
import top.duanhong.emims.pojo.dto.response.PageResponse;
import top.duanhong.emims.pojo.po.MonitorDevice;

import java.util.List;

/**
 * @author duanhong
 * @description 监测设备业务
 * @date 2019/5/22
 */
@Service
public class MonitorDeviceService {
    @Autowired
    private MonitorDeviceRepository monitorDeviceRepository;

    public PageResponse getMonitorDevicesInfo(Pageable pageable, String area) {
        PageResponse pageResponse=new PageResponse();
        Page page=monitorDeviceRepository.findAll(pageable);
        if (page!=null){
            pageResponse.setData(page.getContent());
            pageResponse.setMessage("获取成功");
            pageResponse.setStatus(200);
            pageResponse.setTotalCount(page.getContent().size());
            if (page.getContent().size()==0){
                pageResponse.setMessage("暂无数据");
            }
        }else{
            pageResponse.setStatus(500);
            pageResponse.setMessage("获取失败");
        }
       return pageResponse;
    }

    public MethodExecuteResult saveMonitorDevice(MonitorDevice monitorDevice) {
        MethodExecuteResult methodExecuteResult=new MethodExecuteResult();
        MonitorDevice monitorDev=monitorDeviceRepository.findByDeviceMac(monitorDevice.getDeviceMac());
        if (monitorDev==null){
            monitorDeviceRepository.save(monitorDevice);
            methodExecuteResult.setMessage("新增设备成功");
            methodExecuteResult.setSuccess(true);
        }else {
            methodExecuteResult.setSuccess(false);
            methodExecuteResult.setMessage("该设备已经交存在");
        }
        return methodExecuteResult;
    }

    public MethodExecuteResult deleteMonitorDevices(List<String> deviceIdList) {
        MethodExecuteResult deleteDeviceResult=new MethodExecuteResult();
        int deleteNum=0;
        for (String deviceId:deviceIdList) {
            monitorDeviceRepository.deleteById(Long.parseLong(deviceId));
            deleteNum++;
        }
        deleteDeviceResult.setMessage("成功删除"+deleteNum+"个监测仪");
        deleteDeviceResult.setSuccess(true);
        return deleteDeviceResult;
    }
}
