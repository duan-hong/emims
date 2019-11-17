package top.duanhong.emims.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.duanhong.emims.dao.systemdao.MenuRepository;
import top.duanhong.emims.pojo.po.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author duanhong
 * @description 面包屑工具
 * @date 2019/4/24
 */
@Component
public class CrumbleUtil {

    @Autowired
    private MenuRepository menuRepository;

    private List<Menu> crumbleList;

    /**
     * 返回面包屑数组
     * @param id
     * @return
     */
    public List<Menu> getCrumble(int id){
        crumbleList = new ArrayList<>();
        getParentMenu(id);
        return crumbleList;
    }

    /**
     * 获取父级菜单
     * @param id
     * @return
     */
    public Menu getParentMenu(int id) {
        Optional<Menu> menu=menuRepository.findById(id);
        crumbleList.add(menu.get());
        if (menu.get().getParentId()==0){
            return null;
        }
        return getParentMenu(menu.get().getParentId());
    }
}
