package com.jh.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * @author James
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan({"com.jh.study"})
@EnableWebMvc
public class SpringBootStudyApp {

    /**
     * entrance
     *
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyApp.class, args);
    }

}
