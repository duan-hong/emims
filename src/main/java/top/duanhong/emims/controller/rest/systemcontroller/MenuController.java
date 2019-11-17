package top.duanhong.emims.controller.rest.systemcontroller;

import com.sun.prism.impl.BaseResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.duanhong.emims.controller.utils.ResponseFactory;
import top.duanhong.emims.pojo.dto.response.BaseResponse;
import top.duanhong.emims.pojo.po.Menu;
import top.duanhong.emims.service.systemservice.MenuService;

/**
 * @author duanhong
 * @description 菜单
 * @date 2019/4/21
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public ResponseEntity getAllMenu(int page, int size){
        Page<Menu> result=menuService.getAllMenu(PageRequest.of(page-1, size));
        if (result!=null){
            if (result.getSize()>0){
                return new ResponseEntity(ResponseFactory.getPageResponse(result,null,200),HttpStatus.OK);
            }else {
                return new ResponseEntity(ResponseFactory.getPageResponse(result,"暂无数据",200),HttpStatus.OK);
            }
        }else {
            return new ResponseEntity(ResponseFactory.getPageResponse(result,"获取失败",500),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getBreak(@PathVariable int id){
        BaseResponse baseResponse=menuService.getCrumble(id);
        return new ResponseEntity(ResponseFactory.getBaseResponse(baseResponse.getMessage(),baseResponse.getData()),(Boolean)baseResponse.getExtra()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity saveMenu(Menu menu){
        BaseResponse baseResponse=menuService.saveMenu(menu);
        return new ResponseEntity(ResponseFactory.getBaseResponse(baseResponse.getMessage(),baseResponse.getData()),(Boolean)baseResponse.getExtra()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity updateMenu(@RequestBody Menu menu){
        BaseResponse baseResponse=menuService.updateMenu(menu);
        return new ResponseEntity(ResponseFactory.getBaseResponse(baseResponse.getMessage(),baseResponse.getData()),(Boolean)baseResponse.getExtra()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMenu(@PathVariable Integer id){
        BaseResponse baseResponse=menuService.deleteMenu(id);
        return new ResponseEntity(ResponseFactory.getBaseResponse(baseResponse.getMessage(),baseResponse.getData()),(Boolean)baseResponse.getExtra()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/node")
    public ResponseEntity getAllNode(){
        BaseResponse baseResponse=menuService.getAllNode();
        return new ResponseEntity(ResponseFactory.getBaseResponse(baseResponse.getMessage(),baseResponse.getData()),(Boolean)baseResponse.getExtra()?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }
}
