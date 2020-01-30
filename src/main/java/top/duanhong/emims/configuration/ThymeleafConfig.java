package top.duanhong.emims.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author duanhong
 * @description thmeleaf引擎配置
 * @date 2019/3/23
 */
@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafConfig {
    private static final Charset DEFAULT_ENCODING= StandardCharsets.UTF_8;
    private static final String DEFAULT_PREFIX="classpath:/templates/views/";
    private static final String DEFAULT_SUFFIX=".html";

}
