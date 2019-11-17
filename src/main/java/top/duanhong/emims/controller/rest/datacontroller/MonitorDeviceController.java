package top.duanhong.emims.controller.rest.datacontroller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.duanhong.emims.controller.utils.ResponseFactory;
import top.duanhong.emims.pojo.dto.response.BaseResponse;
import top.duanhong.emims.pojo.dto.response.MethodExecuteResult;
import top.duanhong.emims.pojo.dto.response.PageResponse;
import top.duanhong.emims.pojo.po.MonitorDevice;
import top.duanhong.emims.service.dataservice.dataserviceimpl.MonitorDeviceService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author duanhong
 * @description 监测设备控制器
 * @date 2019/5/22
 */
@Api("监测仪")
@RestController
@RequestMapping("/api/monitorDevice")
public class MonitorDeviceController {
    @Autowired
    private MonitorDeviceService monitorDeviceService;

    @ApiOperation(value = "监测仪",notes = "获取监测仪列表")
    @GetMapping
    public PageResponse getMonitorDevicesInfo(int page, int size){
        Pageable pageable= PageRequest.of(page-1,size);
        String area="";
        PageResponse pageResponse=monitorDeviceService.getMonitorDevicesInfo(pageable,area);
        return pageResponse;
    }

    @ApiOperation(value = "检测仪",notes = "添加新的监测仪")
    @PostMapping
    public ResponseEntity saveMonitorDevice(MonitorDevice monitorDevice){
        MethodExecuteResult addDeviceResult=monitorDeviceService.saveMonitorDevice(monitorDevice);
        return new ResponseEntity(ResponseFactory.getBaseResponse(addDeviceResult.getMessage(),addDeviceResult.getData()),addDeviceResult.isSuccess()?
        HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "检测仪",notes = "删除检测仪")
    @PostMapping("/delete")
    public ResponseEntity deleteMonitorDevices(String deleteDeviceIds){
        List idList=new ArrayList();
        Collections.addAll(idList,deleteDeviceIds.split("-"));
        MethodExecuteResult deleteDeviceResult=monitorDeviceService.deleteMonitorDevices(idList);
        return new ResponseEntity(ResponseFactory.getBaseResponse(deleteDeviceResult.getMessage(),deleteDeviceResult.getData()),deleteDeviceResult.isSuccess()?
                HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

}
