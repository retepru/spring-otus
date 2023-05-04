package ru.otus.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.otus.spring.config.AppProps;
import ru.otus.spring.service.AppRun;


@EnableAspectJAutoProxy
@SpringBootApplication
@EnableConfigurationProperties(AppProps.class)
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        AppRun appRun = context.getBean(AppRun.class);
                appRun.run();
    }
}
