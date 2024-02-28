package com.utdallas.capstone;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScans;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@Slf4j
public class CapstoneApplication {

	public static void main(String[] args) {
		log.info("************* BOOTING CAPSTONE APPLICATION *************");
		SpringApplication.run(CapstoneApplication.class, args);
		log.info("************* BOOTED CAPSTONE APPLICATION *************");

	}

}
