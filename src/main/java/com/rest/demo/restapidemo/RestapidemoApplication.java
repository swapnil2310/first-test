package com.rest.demo.restapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.rest.demo.restapidemo.custom.SQLInitConfiguration;

/**
 * @author swasrivastava
 *
 */
@SpringBootApplication
@ImportResource({"classpath*:application-config.xml"})
public class RestapidemoApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestapidemoApplication.class, args);
		try {
			SQLInitConfiguration.init(new SQLInitConfiguration());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
