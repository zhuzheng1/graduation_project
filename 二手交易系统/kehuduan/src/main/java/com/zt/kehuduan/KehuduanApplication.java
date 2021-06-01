package com.zt.kehuduan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zt.kehuduan.dao")
public class KehuduanApplication {

    public static void main(String[] args) {
        SpringApplication.run(KehuduanApplication.class, args);
    }

}
