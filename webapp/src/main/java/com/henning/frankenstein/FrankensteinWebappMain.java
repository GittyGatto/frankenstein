
package com.henning.frankenstein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = "com.henning")
@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:application.${env}.properties"})
@EnableScheduling
@EnableJpaRepositories
@EnableTransactionManagement
@EnableWebMvc
public class FrankensteinWebappMain {
    public static void main(String[] args) {

        SpringApplication.run(FrankensteinWebappMain.class, args);

        System.err.println("ready");
    }
}