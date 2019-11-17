package top.duanhong.emims.configuration.securityconfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author duanhong
 * @description 加载配置
 * @date 2019/4/17
 */
@Configuration
@EnableConfigurationProperties(SecurityPropertise.class)
public class SecurityCoreConfig {
}
