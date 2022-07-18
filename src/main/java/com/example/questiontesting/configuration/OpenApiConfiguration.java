package com.example.questiontesting.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(info());
    }
    @Bean
    public Info info(){
        return new Info()
                .description("Test description")
                .title("My Question Api")
                .version("1.0")
                .contact(contact());
    }
    @Bean
    public Contact contact(){
        return new Contact()
                .name("My contact")
                .email("test@mail.ru")
                .url("https://github.com/FrolovSergey1987");
    }
}
