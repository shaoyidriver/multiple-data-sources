package com.sy.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
//是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露！），可根据springboot的多环境配置进行设置
@ConditionalOnProperty(prefix = "swagger2",value = {"enable"},havingValue = "true")
public class SwaggerConfig {
    /**
     * swagger Demo配置
     * @return 结果集
     */
    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("API接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sy.controller"))
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(getPars());
    }

    /**
     * swagger 文档描述
     * @return 结果集
     */
    private ApiInfo apiInfo(){
        //作者
        Contact contact = new Contact("wt","","");
        return new ApiInfoBuilder()
                //页面标题
                .title("接口总览")
                //作者
                .contact(contact)
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

}
