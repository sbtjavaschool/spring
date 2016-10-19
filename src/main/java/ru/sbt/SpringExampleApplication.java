package ru.sbt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.EnableRetry;
import ru.sbt.service.ScheduleService;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ImportResource({"classpath*:config.xml", "classpath*:prod-config.xml"})
@PropertySource("secret.properties")
@ComponentScan("ru.sbt")
@EnableRetry
public class SpringExampleApplication {
    private final ScheduleService service;

    @Autowired
    public SpringExampleApplication(@Qualifier("db") ScheduleService service) {
        this.service = service;
    }

    @PostConstruct
    public void onStartup() {
//        service.calc();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringExampleApplication.class, args);
    }
}