package top.duanhong.emims.service.systemservice.systemserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.duanhong.emims.dao.systemdao.MenuRepository;
import top.duanhong.emims.pojo.dto.response.BaseResponse;
import top.duanhong.emims.pojo.dto.system.Node;
import top.duanhong.emims.pojo.po.Menu;
import top.duanhong.emims.service.systemservice.MenuService;
import top.duanhong.emims.service.utils.CrumbleUtil;
import top.duanhong.emims.service.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author duanhong
 * @description 菜单
 * @date 2019/4/21
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CrumbleUtil crumbleUtil;

    @Override
    public Page<Menu> getAllMenu(Pageable pageable) {
        Page<Menu> page=menuRepository.findAll(pageable);
        return page;
    }

    @Override
    public BaseResponse saveMenu(Menu menu) {
        Menu result=menuRepository.save(menu);
        BaseResponse baseResponse=new BaseResponse();
        if (result!=null){
            baseResponse.setExtra(true);
            baseResponse.setMessage("保存成功");
        }else {
            baseResponse.setExtra(false);
            baseResponse.setMessage("保存失败");
        }
        return baseResponse;
    }

    @Override
    public BaseResponse updateMenu(Menu menu) {
        Menu result=menuRepository.save(menu);
        BaseResponse updateResponse=new BaseResponse();
        if (result!=null){
            updateResponse.setExtra(true);
            updateResponse.setMessage("保存成功");
        }else {
            updateResponse.setExtra(false);
            updateResponse.setMessage("保存失败");
        }
        return updateResponse;
    }

    @Override
    public BaseResponse deleteMenu(Integer id) {
        BaseResponse baseResponse=new BaseResponse();
        menuRepository.deleteById(id);
        Optional optional=menuRepository.findById(id);
        if (optional.isPresent()){
            baseResponse.setMessage("删除失败");
            baseResponse.setExtra(false);
        }else {
            baseResponse.setMessage("删除成功");
            baseResponse.setExtra(true);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse getAllNode() {
        List<Menu> menuList=menuRepository.findAll();
        List<Node> nodeList =new ArrayList<>();
        BaseResponse baseResponse=new BaseResponse();
        for (Menu menu: menuList) {
            Node node=new Node();
            node.setId(menu.getId());
            node.setName(menu.getNodeName());
            node.setHref(menu.getUrl());
            node.setParentId(menu.getParentId());
            nodeList.add(node);
        }
        List<Node> list=TreeUtil.toTree(nodeList);
        if(list!=null&&list.size()>0){
            baseResponse.setData(list);
            baseResponse.setMessage("获取节点成功");
            baseResponse.setExtra(true);
        }else {
            baseResponse.setMessage("获取节点失败");
            baseResponse.setExtra(false);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse getCrumble(int id) {
        List<Menu> list=crumbleUtil.getCrumble(id);
        BaseResponse baseResponse=new BaseResponse();
        if(list.size()!=0){
            baseResponse.setExtra(true);
            baseResponse.setMessage("获取面包屑成功");
            baseResponse.setData(list);
        }else {
            baseResponse.setExtra(false);
            baseResponse.setMessage("获取面包屑失败");
            baseResponse.setData(list);
        }
        return baseResponse;
    }

}
