

# 模块说明
| 模块                   | 说明                  |
|----------------------|---------------------|
| base-commons         | 公共模块                |
| base-web             | WEB通用组件             |
| find-cloud-gateway   | 网关                  |
| find-cloud-generator | 数据模型代码生成器           |
| find-cloud-nacos     | nacos               |
| find-cloud-oauth2    | gateway集成oauth2认证插件 |
| find-cloud-parent    | 父根级模块               |
| find-cloud-third     | 第三方插件               |
| find-cloud-user      | 用户                  |

# 插件依赖说明

| 插件                                           | 版本            | 说明                       |
|----------------------------------------------|---------------|--------------------------|
| spring-cloud-dependencies                    | 2021.0.0      | spring-cloud依赖包          |
| spring-boot-dependencies                     | 2.6.1         | spring-boot依赖包           |
| spring-cloud-security-dependencies           | 2.2.5.RELEASE | spring-cloud-security依赖包 |
| spring-cloud-starter-gateway                 | 2.2.6.RELEASE | gateway网关依赖包             |
| spring-cloud-starter-alibaba-nacos-discovery | 2021.1        | nacos依赖包                 |
| mysql-connector-java                         | 8.0.28        | mysql驱动包                 |
| mybatis-plus-boot-starter                    | 3.4.3.4       | mybatis-plus依赖包          |
| lombok                                       | 1.18.4        | lombok依赖包                |
| springfox-boot-starter                       | 3.0.0         | swagger文档依赖包             |
| commons-lang3                                | 3.12.0        | lang3公共组件依赖包             |
| commons-pool2                                | 2.11.1        | 连接池公共组件依赖包               |
| mapstruct                                    | 1.4.2.Final   | 对象映射mapstruct组件依赖包       |
| mapstruct-processor                          | 1.4.2.Final   | 对象映射mapstruct组件相关依赖包     |
| fastjson                                     | 1.2.79        | 阿里fastjson依赖包            |
| tea-openapi                                  | 0.2.2         | 阿里开发API核心依赖包             |
| dysmsapi20170525                             | 2.0.9         | sms短信依赖包                 |


## 说明
 + 本项目采用极光认证手机一键登录，故对于OAUTH2的认证不予采用，find-cloud-oauth2模块弃用
