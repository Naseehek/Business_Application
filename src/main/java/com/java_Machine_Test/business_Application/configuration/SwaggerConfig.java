//package com.java_Machine_Test.business_Application.configuration;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@OpenAPIDefinition(
//        info = @Info(title = "Product and Sales API s", version = "1.0"),
//        security = @SecurityRequirement(name = "basicAuth");
//)
//@SecurityScheme(
//        name = "basicAuth",
//        type = SecuritySchemeType.HTTP,
//        scheme = "basic"
//)
//public class SwaggerConfig {
//
////    @Bean
////    public OpenAPI customOpenAPI() {
////        return new OpenAPI()
////                .components(new Components())
////                .addSecurityItem("basicAuth",
////                        new SecurityScheme()
////                                .type(SecurityScheme.Type.HTTP)
////                                .scheme("basic")));
////    }
//}
