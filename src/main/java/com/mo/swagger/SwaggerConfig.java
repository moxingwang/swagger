package com.mo.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description:
 * @author: MoXingwang 2018-07-16 16:53
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.switch}")
    private boolean swaggerSwitch;

/*    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }*/

    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        if (swaggerSwitch) {
            docket.enable(true);
        } else {
            docket.enable(false);
        }

        docket.apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();

        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("swagger接口测试").description("swagger接口测试")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .license("China Red Star Licence Version 1.0").licenseUrl("#").version("1.0").build();
    }

}
