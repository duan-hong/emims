package top.duanhong.emims.configuration.configbean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author duanhong
 * @description 首页配置,,,,设置从gis系统的首页名
 * @date 2020/1/29
 */
@Component
@Data
@RefreshScope
public class EmimsIndexConfig {

    @Value("${indexViewName}")
    private String indexViewName;

}
