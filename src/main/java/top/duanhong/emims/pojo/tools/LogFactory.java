package top.duanhong.emims.pojo.tools;

import org.apache.log4j.Logger;

/**
 * @author duanhong
 * @description 日志
 * @date 2019/5/11
 */
public class LogFactory {
    public static Logger getLogger(Class clazz){
        return Logger.getLogger(clazz);
    }
}
