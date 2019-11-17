package top.duanhong.emims.dao.systemdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.duanhong.emims.pojo.po.Menu;

import java.util.List;

/**
 * dunahong
 * @author Administrator
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {
    /**
     * 根据父节点获取菜单
     * @param parentId
     * @return
     */
    List<Menu> findByParentId(int parentId);
}
