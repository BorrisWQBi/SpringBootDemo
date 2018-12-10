package com.borris.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.borris.mapper")
@ComponentScan(basePackages = {"com.borris"})
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringBootDemoApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		SpringBootDemoApplication.class.getAnnotations();
	}

}
