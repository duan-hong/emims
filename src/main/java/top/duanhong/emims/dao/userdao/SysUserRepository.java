package top.duanhong.emims.dao.userdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.duanhong.emims.pojo.po.SysUser;

/**
 * duanhong
 * @author Administrator
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    /**
     * 用户民查找
     * @param userName
     * @return
     */
    SysUser findAllByUserName(String userName);
}
