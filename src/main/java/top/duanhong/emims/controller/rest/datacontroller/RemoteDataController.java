package top.duanhong.emims.controller.rest.datacontroller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.duanhong.emims.controller.utils.ResponseFactory;
import top.duanhong.emims.service.dataservice.remotedatahandle.RemoteDataService;

/**
 * @author duanhong
 * @description 远程数据
 * @date 2019/5/6
 */
@Api("远程数据")
@RestController
@RequestMapping("/api/remoteData")
public class RemoteDataController {
    @Autowired
    private RemoteDataService remoteDataService;

    @ApiOperation(value = "远程数据",notes = "获取远程数据")
    @GetMapping
    public ResponseEntity getRemoteData(int page,int size){
        Pageable pageable= PageRequest.of(page,size);//new Sort(Sort.Direction.DESC, "receiveDate"
        Page remoteDataResult=remoteDataService.getRemoteData(pageable);
        if (remoteDataResult!=null){
            if (remoteDataResult.getSize()>0){
                return new ResponseEntity(ResponseFactory.getPageResponse(remoteDataResult,null,200), HttpStatus.OK);
            }else {
                return new ResponseEntity(ResponseFactory.getPageResponse(remoteDataResult,"暂无数据",200),HttpStatus.OK);
            }
        }else {
            return new ResponseEntity(ResponseFactory.getPageResponse(remoteDataResult,"获取失败",500),HttpStatus.BAD_REQUEST);
        }
    }
}
