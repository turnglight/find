package base.web.autoconfigure;

import base.web.mybatisplus.MyMetaObjectHandler;
import base.web.mybatisplus.MybatisPlusConfig;
import base.web.swagger.SwaggerConfiguration;
import base.web.swagger.SwaggerProperties;
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
        MyMetaObjectHandler.class,
        SwaggerConfiguration.class,
        SwaggerProperties.class,
})
@ComponentScan(basePackages = {
        "base.web.handler"
})
public class BaseWebAutoConfiguration {
}