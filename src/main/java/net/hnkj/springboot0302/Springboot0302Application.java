package net.hnkj.springboot0302;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("net.hnkj.springboot0302.mapper")
@EnableTransactionManagement
public class Springboot0302Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot0302Application.class, args);
    }

}
