package com.esampaio.orig.api.config.swagger;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import springfox.documentation.builders.*;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .globalResponses(HttpMethod.GET,
                        singletonList(new ResponseBuilder()
                                .code("500")
                                .description("500 Um erro desconhecido aconteceu")
//                                .representation(MediaType.TEXT_XML)
//                                .apply(r ->
//                                        r.model(m ->
//                                                m.referenceModel(ref ->
//                                                        ref.key(k ->
//                                                                k.qualifiedModelName(q ->
//                                                                        q.namespace("some:namespace")
//
//                                                                                .name("ERROR"))))))
                                .build()
                        ))
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Documentação da api do projeto XXX")
                .description("Um exemplo da documentação do projeto XXX com todas as requisições e respostas possíveis ")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                        .contact(new Contact("Eduardo S. Sampaio", null, "eduardo.ssampaio@outlook.com"))
                        .build();
    }

}
