package com.vinicius.techtalk.customers.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("customer-api").select()
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build()
                .apiInfo(apiInfo()).globalResponseMessage(RequestMethod.GET, responseMessages());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Customer").description("Customer - TechTalks").version("v1").build();
    }

    private List<ResponseMessage> responseMessages() {
        final List<ResponseMessage> responseMessages = new ArrayList<>();

        responseMessages.add(new ResponseMessageBuilder().code(200).message("Success").build());
        responseMessages.add(new ResponseMessageBuilder().code(401).message("Unauthorized").build());
        responseMessages.add(new ResponseMessageBuilder().code(403).message("Forbidden").build());
        responseMessages.add(new ResponseMessageBuilder().code(404).message("Not Found").build());
        responseMessages.add(new ResponseMessageBuilder().code(500).message("Failure").build());

        return responseMessages;
    }
}
