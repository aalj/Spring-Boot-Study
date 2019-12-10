package spring.boot.security.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("spring.boot.security.sample.mapper")
public class SecuritySampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecuritySampleApplication.class, args);
    }
}
