package top.duanhong.emims.controller.rest.systemcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.duanhong.emims.configuration.configbean.EmimsIndexConfig;
import top.duanhong.emims.pojo.tools.LogFactory;
import top.duanhong.emims.service.systemservice.MenuService;

/**
 * 前端页面获取
 * @author Administrator
 */
@Controller
public class PageController {

    @Autowired
    private EmimsIndexConfig emimsIndexConfig;

    @Autowired
    private MenuService menuService;

    private Logger log= LogFactory.getLogger(PageController.class);

    @GetMapping("/api/getPageByName")
    public String getPageByName(String pageName) {
        log.info("模板请求："+pageName);
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(pageName);
        if ("index".equals(pageName)){
            MethodExecuteResult result=menuService.getAllNode();
            List<Node> noSonsNode = new ArrayList<>();
            List<Node> haveSonsNode=new ArrayList<>();
            if (result.isSuccess()){
                haveSonsNode = (List<Node>) result.getData();
                for (Node node : haveSonsNode) {
                    if (node.getChildren().size() == 0) {
                        noSonsNode.add(node);
                    }
                }
            }
            modelAndView.addObject("allNode", haveSonsNode);
            modelAndView.addObject("noSonsNode", noSonsNode);
        }*/
        return "page/"+pageName;

    }

    @RequestMapping("/")
    public ModelAndView goIndex() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("page/gis");
        modelAndView.addObject("indexViewName",emimsIndexConfig.getIndexViewName());
        return modelAndView;
    }
}
