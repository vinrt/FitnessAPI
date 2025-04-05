package com.vinrt.fitnessapp.config;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;

/**
 * Created by vinayraghavtiwari : 28/12/18.
 * Updated : 26/02/22
 */
@EnableSwagger2
public class SwaggerClass {

    @Bean
    public Docket GymApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vinrt.fitnessapp"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }
    private ApiInfo metaInfo()
    {
        return new ApiInfo(
                "Anytime Fitness Stockholm",
                "Fitness application only in Stockholm",
                "2.1.2",
                null,
                 "https://github.com/vinrt",
                null,
                null);
    }
}
