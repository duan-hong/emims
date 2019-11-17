package top.duanhong.emims.controller.rest.user;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.duanhong.emims.pojo.po.User;

/**
 * @author duanhong
 * @description 用户
 * @date 2019/4/30
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user){
        return null;
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user){
        return null;
    }

    @GetMapping
    public ResponseEntity getUser(String userName, String userRole, Pageable pageable){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        return null;
    }
}
