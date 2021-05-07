package com.labforward.similarities.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${com.labforward.docs.title:Labforward Similarities}")
  private String serviceTitle;

  @Value("${com.labforward.docs.description:API Documentation Labforward Similarities.}")
  private String serviceDescription;

  @Value("${com.labforward.docs.base-package:com.labforward}")
  private String serviceBasePackage;

  @Value("${com.labforward.docs.version:1.0.0}")
  private String serviceVersion;

  @Value("${com.labforward.docs.contact:khaled Mosaad Mohamed <engkhaledmos3ad@gmail.com>}")
  private String serviceContact;

  public static final String DEFAULT_INCLUDE_PATTERN = "/*/.*";

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(serviceTitle)
        .version(serviceVersion)
        .description(serviceDescription)
        .contact(new Contact(serviceTitle, null, serviceContact))
        .build();
  }

  @Bean
  public Docket configureDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage(serviceBasePackage))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
  }
}
