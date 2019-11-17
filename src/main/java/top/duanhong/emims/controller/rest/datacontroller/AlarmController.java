package top.duanhong.emims.controller.rest.datacontroller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.duanhong.emims.controller.utils.ResponseFactory;
import top.duanhong.emims.service.dataservice.dataserviceimpl.AlarmService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author duanhong
 * @description 预警控制器
 * @date 2019/5/4
 */

@Api("预警")
@RestController
@RequestMapping("/api/alarm")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    /**
     * 获取所有警报消息
     * @param start
     * @param end
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "预警信息",notes = "根据日期查询预警信息")
    @GetMapping("/all")
    public ResponseEntity getAllAlarm(String searchText,@RequestParam String start, @RequestParam String end, int page, int size){
        Pageable pageable= PageRequest.of(page-1,size);
        Page result=alarmService.serach(searchText,start,end,pageable);
        if (result!=null){
            if (result.getSize()>0){
                return new ResponseEntity(ResponseFactory.getPageResponse(result,null,200), HttpStatus.OK);
            }else {
                return new ResponseEntity(ResponseFactory.getPageResponse(result,"暂无数据",200),HttpStatus.OK);
            }
        }else {
            return new ResponseEntity(ResponseFactory.getPageResponse(result,"获取失败",500),HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 获取最新警报消息
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "预警信息",notes = "获取最新预警信息")
    @GetMapping("/new")
    public ResponseEntity getNewAlarm(int page,int size){
        Pageable pageable=PageRequest.of(page-1,size);
        Page result=alarmService.getNewAlarm(pageable);
        if (result!=null){
            if (result.getSize()>0){
                return new ResponseEntity(ResponseFactory.getPageResponse(result,"获取数据成功",200), HttpStatus.OK);
            }else {
                return new ResponseEntity(ResponseFactory.getPageResponse(result,"暂无数据",200),HttpStatus.OK);
            }
        }else {
            return new ResponseEntity(ResponseFactory.getPageResponse(result,"获取失败",500),HttpStatus.BAD_REQUEST);
        }
    }
}
