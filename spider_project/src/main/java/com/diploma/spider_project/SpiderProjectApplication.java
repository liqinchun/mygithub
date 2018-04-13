package com.diploma.spider_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //扫描使用注解方式的servlet
public class SpiderProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpiderProjectApplication.class, args);
	}
}
