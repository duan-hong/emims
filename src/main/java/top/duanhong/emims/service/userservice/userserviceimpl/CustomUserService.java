package top.duanhong.emims.service.userservice.userserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.duanhong.emims.dao.userdao.SysUserRepository;

/**
 * 用户安全认证，获取登陆者信息
 * @author duanhong
 * @description userService
 * @date 2019/4/6
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails userDetails=sysUserRepository.findAllByUserName(s);
        return userDetails;
    }
}
