package com.zhangxin.zhangxinuniverse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhangxin.zhangxinuniverse.mapper")
public class ZhangxinUniverseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhangxinUniverseApplication.class, args);
    }

}
