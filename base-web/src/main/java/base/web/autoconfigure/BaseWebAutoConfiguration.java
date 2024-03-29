package base.web.autoconfigure;

import base.web.mybatisplus.MyMetaObjectHandler;
import base.web.mybatisplus.MybatisPlusConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author 01407975
 * @description WEB自动配置启动
 * @date 2021/12/13
 */
@Configuration
@Import({
        MybatisPlusConfig.class,
        MyMetaObjectHandler.class
})
@ComponentScan(basePackages = {
        "base.web.handler"
})
public class BaseWebAutoConfiguration {
}
