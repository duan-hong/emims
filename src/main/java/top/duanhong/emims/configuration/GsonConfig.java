/*
package top.duanhong.emims.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;

*/
/**
 * @author duanhong
 * @description gson处理器配置
 * GsonHttpMessageConverterConfigration中的源码指出当项目没有提供GsonHttpMessageConverter的时候
 * 会使用默认的，所以，如若想使用自定义的GsonHttpMessageConverter，则自己配置一个实例即可
 * @date 2019/3/23
 *//*

@Configuration
public class GsonConfig {
    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter(){
        */
/**
         * 代码解释：
         * 1、开发者自己提供一个gsonHttpMessageConverter
         * 2、设置json解析是的日期格式
         * 3、设置gson解析是修饰符为protece的字段被过滤掉
         * 4、创建gson对象放入gsonHttpMessageConverter中并返回这个消息转换器实例
         *//*

        GsonHttpMessageConverter gsonHttpMessageConverter=new GsonHttpMessageConverter();
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
        //去除某修饰符修饰的属性，即不予返回这个字段
        gsonBuilder.excludeFieldsWithModifiers(Modifier.PROTECTED);
        Gson gson=gsonBuilder.create();
        gsonHttpMessageConverter.setGson(gson);
        return gsonHttpMessageConverter;
    }
}
*/
