package top.duanhong.emims.service.userservice.userserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.duanhong.emims.dao.userdao.SysUserRepository;

/**
 * @author duanhong
 * @description 用户业务
 * @date 2019/4/30
 */
@Service
public class UserService {
    @Autowired
    private SysUserRepository sysUserRepository;

}
