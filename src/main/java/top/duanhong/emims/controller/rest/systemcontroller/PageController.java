package top.duanhong.emims.controller.rest.systemcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.duanhong.emims.pojo.dto.response.BaseResponse;
import top.duanhong.emims.pojo.dto.system.Node;
import top.duanhong.emims.pojo.tools.LogFactory;
import top.duanhong.emims.service.systemservice.MenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * 前端页面获取
 * @author Administrator
 */
@Controller
public class PageController {
    @Autowired
    private MenuService menuService;

    private Logger log= LogFactory.getLogger(PageController.class);

    @GetMapping("/api/getPageByName")
    public ModelAndView getPageByName(String pageName) {
        log.info("模板请求："+pageName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("views/"+pageName);
        if ("homepage".equals(pageName)){
            BaseResponse baseResponse = menuService.getAllNode();
            List<Node> haveSonsNode = (List<Node>) baseResponse.getData();
            List<Node> noSonsNode = new ArrayList<>();
            for (Node node : haveSonsNode) {
                if (node.getChildren().size() == 0) {
                    noSonsNode.add(node);
                }
            }
            if (baseResponse.getData() != null) {
                modelAndView.addObject("allNode", haveSonsNode);
                modelAndView.addObject("noSonsNode", noSonsNode);
            }
        }
        return modelAndView;
    }

    @RequestMapping("/")
    public ModelAndView goIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("views/gis");
        return modelAndView;
    }
}
