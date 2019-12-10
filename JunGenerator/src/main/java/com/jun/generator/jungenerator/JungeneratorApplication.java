package com.jun.generator.jungenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.jun.generator.jungenerator.mapper")
public class JungeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JungeneratorApplication.class, args);
    }

}
