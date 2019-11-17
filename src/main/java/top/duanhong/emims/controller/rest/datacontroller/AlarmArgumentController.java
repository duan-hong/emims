package top.duanhong.emims.controller.rest.datacontroller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.duanhong.emims.controller.utils.ResponseFactory;
import top.duanhong.emims.pojo.dto.response.MethodExecuteResult;
import top.duanhong.emims.pojo.dto.response.PageResponse;
import top.duanhong.emims.pojo.po.AlarmArgument;
import top.duanhong.emims.service.dataservice.dataserviceimpl.AlarmArgumentService;

/**
 * @author duanhong
 * @description 预警参数控制
 * @date 2019/5/16
 */

@Api("预警参数")
@RestController
@RequestMapping("/api/alarmArgument")
public class AlarmArgumentController {
    @Autowired
    private AlarmArgumentService alarmArgumentService;


    @ApiOperation(value = "预警参数",notes = "增加一条预警参数")
    @PostMapping
    public ResponseEntity saveAlarmArgument(AlarmArgument alarmArgument){
        AlarmArgument result=alarmArgumentService.saveAlarmArgument(alarmArgument);
        if (result!=null){
            return new ResponseEntity(ResponseFactory.getBaseResponse("保存成功",result), HttpStatus.OK);
        }else {
            return new ResponseEntity(ResponseFactory.getBaseResponse("保存失败",null), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "预警参数",notes = "更新预警参数")
    @PostMapping("/update")
    public ResponseEntity updateAlarmArgument(AlarmArgument alarmArgument){
        MethodExecuteResult methodExecuteResult=alarmArgumentService.updateAlarmArgument(alarmArgument);
        if (methodExecuteResult.isSuccess()){
            return new ResponseEntity(ResponseFactory.getBaseResponse(methodExecuteResult.getMessage(),methodExecuteResult.getData()), HttpStatus.OK);
        }else {
            return new ResponseEntity(ResponseFactory.getBaseResponse(methodExecuteResult.getMessage(),null), HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "预警参数",notes = "获取预警参数")
    @GetMapping
    public ResponseEntity getAlarmArguments(String deviceMac){
       MethodExecuteResult methodExecuteResult=alarmArgumentService.getAlarmArguments(deviceMac);
       if (methodExecuteResult.isSuccess()){
           return new ResponseEntity(ResponseFactory.getBaseResponse(methodExecuteResult.getMessage(),methodExecuteResult.getData()),HttpStatus.OK);
       }else{
           return new ResponseEntity(ResponseFactory.getBaseResponse(methodExecuteResult.getMessage(),methodExecuteResult.getData()),HttpStatus.BAD_REQUEST);
       }
    }
}
