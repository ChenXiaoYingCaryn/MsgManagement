package com.example.msgmanagementdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author xiaoying
 * @create 2021-11-30 上午 10:55
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    配置了Swagger的Docket的Bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Caryn")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.msgmanagementdemo.controller"))
                .build();
    }

    //配置Swagger信息=apiInfo
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("Caryn", "urn:tos", "739130811@qq.com");

        return new ApiInfo(
                "msg_management SwaggerAPI",
                "Api Documentation",
                "v1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


}
