package com.maxsh.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/03
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("1-用户管理", "用户管理的API"), getTags())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.maxsh.swagger.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private Tag[] getTags() {
        Tag[] tags = {
                new Tag("2-消息管理", "消息管理的API"),
                new Tag("3-表格相关", "表格相关的API")
        };
        return tags;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户管理")
                .description("用户管理系统 API 1.0 操作文档")
                //服务条款网址
                .termsOfServiceUrl("http://www.maxsh.cn/")
                .version("v 1.0")
                .contact(new Contact("Maxsh", "http://www.maxsh.cn/", "869209045@qq.com"))
                .build();
    }
}
