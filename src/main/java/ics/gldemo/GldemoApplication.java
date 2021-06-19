package ics.gldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "demo.dao")
public class GldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GldemoApplication.class, args);
    }

}
