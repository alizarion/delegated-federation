package io.github.alizarion.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author selim@openlinux.fr
 */
@SpringBootApplication
@ComponentScan( {"io.github.alizarion.springboot",
        "com.itesoft.common.utils.security",
        "io.github.alizarion.springboot.api",
        "com.itesoft.common.properties"})
@EntityScan(basePackages = "io.github.alizarion.springboot.entities")
public class Application extends SpringBootServletInitializer {

    private static Class<Application> appClass = Application.class;


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(appClass);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}