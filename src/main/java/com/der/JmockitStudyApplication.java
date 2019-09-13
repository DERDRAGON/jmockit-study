package com.der;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ImportResource(locations = {"classpath:spring-config.xml","classpath:dubbo/dubbo-*.xml"})
public class JmockitStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmockitStudyApplication.class, args);
	}

}
