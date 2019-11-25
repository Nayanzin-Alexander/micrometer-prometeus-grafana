package com.nayanzin.micrometerprometeusgrafana.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getDocket() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nayanzin"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Micrometer-Prometheus-Grafana sample application.")
                .description("")
                .termsOfServiceUrl("")
                .version("")
                .contact(getContact())
                .build();
    }

    private Contact getContact() {
        return new Contact("Nayanzin Alexander", "", "");
    }
}
