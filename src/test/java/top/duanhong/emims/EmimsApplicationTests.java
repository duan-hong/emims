package top.duanhong.emims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.duanhong.emims.dao.userdao.SysUserRepository;
import top.duanhong.emims.pojo.dto.response.BaseResponse;
import top.duanhong.emims.pojo.po.SysUser;
import top.duanhong.emims.service.systemservice.MenuService;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmimsApplicationTests {
    @Autowired
    MenuService menuService;
    @Test
    public void encodeTest(){
        BaseResponse baseResponse=menuService.getCrumble(126);
        System.out.println(baseResponse.getData());

    }
}
