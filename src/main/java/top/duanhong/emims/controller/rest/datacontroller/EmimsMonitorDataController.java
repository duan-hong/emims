package top.duanhong.emims.controller.rest.datacontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.duanhong.emims.pojo.dto.response.BaseMessage;
import top.duanhong.emims.controller.utils.ResponseFactory;
import top.duanhong.emims.pojo.po.Temp;
import top.duanhong.emims.service.dataservice.TempService;

import java.util.ArrayList;
import java.util.Date;

/**
 * 环境监测温度数据处理
 * @author Administrator
 */
@Controller
public class EmimsMonitorDataController {

    @Autowired
    private TempService tempService;
    /**
     * 温度
     * @return
     */
    @RequestMapping("/getT")
    @ResponseBody
    public ResponseEntity getT(@RequestParam int page,@RequestParam int size) {
        /*
        bootatrap-table 用total判断是否加载页数工具条，用rows加载数据;
        bootatrap-table 向后端传递page和pagesize来分页查询。
        */
        //创建时间降序排序
//        Sort sort = new Sort(Sort.Direction.DESC,"saveTime");
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Temp> result = tempService.getT(pageable);
        if (result!=null){
            if (result.getSize()>0){
                return new ResponseEntity(ResponseFactory.getPageResponse(result,null,200),HttpStatus.OK);
            }else {
                return new ResponseEntity(ResponseFactory.getPageResponse(result,"暂无数据",200),HttpStatus.OK);
            }
        }else {
            return new ResponseEntity(ResponseFactory.getPageResponse(result,"获取失败",500),HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/insertT")
    @ResponseBody
    public ResponseEntity insertT(){

        int insertNum=0;
        ArrayList<Temp> arrayList=new ArrayList<>();
        for (int i=0;i<100;i++){
            double ran=Math.random();
            double ran1=Math.random();
            double ran2=Math.random();
            double ran3=Math.random();
            double tem=((int)ran*30+10)+ran;
            double altitude=((int)ran*100+100)+ran1;
            double latitude=((int)ran*100+100)+ran2;
            double longtitude=((int)ran*100+100)+ran3;
            int deviceChar=(int)Math.random()*26;
            char c= (char) (deviceChar+97);
            Temp t=new Temp();
            t.setTemperature((float)tem);
            t.setAltitude((float)altitude);
            t.setLatitude((float)latitude);
            t.setLongtitude((float)longtitude);
            t.setLocation("陕西省/咸阳市/武功县/小村镇");
            t.setSaveTime(new Date());
            t.setDeviceId("352425026947815");
            Temp result=tempService.insertT(t);
            arrayList.add(result);
            if (result!=null){
                insertNum++;
            }
        }
        return new ResponseEntity(ResponseFactory.getBaseResponse("插入成功",arrayList), HttpStatus.OK);
    }






    /**
     * 紫外线
     * @return
     */
    @RequestMapping("/getUltra")
    public String getAltra(){

        return "";
    }

    /**
     * Pm2.5
     * @return
     */
    @RequestMapping("/getPm")
    public String getPm(){

        return "";
    }

    /**
     * 大气压
     * @return
     */
    @RequestMapping("/getAtomPressure")
    public String getAtomPressure(){

        return "";
    }

    /**
     * 其他数据
     * @return
     */
    @RequestMapping("/getOthers")
    public String getOthers(){

        return "";
    }

}
