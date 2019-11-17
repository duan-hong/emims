package top.duanhong.emims.service.systemservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.duanhong.emims.pojo.dto.response.BaseResponse;
import top.duanhong.emims.pojo.po.Menu;

/**
 * duanhong
 * @author Administrator
 */
public interface MenuService {
    /**
     * 获取所有菜单
     * @return
     * @param pageable
     */
    Page<Menu> getAllMenu(Pageable pageable);

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    BaseResponse saveMenu(Menu menu);

    /**
     * 修改菜单信息
     * @param menu
     * @return
     */
    BaseResponse updateMenu(Menu menu);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    BaseResponse deleteMenu(Integer id);

    /**
     * 获取所有节点
     * @return
     */
    BaseResponse getAllNode();

    /**
     * 根据菜单id获取面包屑
     * @param id
     * @return
     */
    BaseResponse getCrumble(int id);
}
