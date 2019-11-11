package com.rest.demo.restapidemo.custom;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

public class SQLInitConfiguration {
	
	@QueryReader("insertEmployee")
	public static String insertEmployee ; 
	@QueryReader("retrieveEmployee")
	public static String retrieveEmployee ; 
	
	public static void init(Object object) throws Exception {
		if(Objects.isNull(object)) {
			throw new Exception("The object to serialize is null");
		}
		Class<?> clazz = object.getClass();
		for(Field field : clazz.getDeclaredFields()) {
			if(field.isAnnotationPresent(QueryReader.class)) {
				InputStream inputStream = new ClassPathResource("sql/" + field.getName() + ".sql").getInputStream();
				String data = IOUtils.toString(inputStream,StandardCharsets.UTF_8);
				field.set(object, data);
			}
		}
		
	}
	

}
