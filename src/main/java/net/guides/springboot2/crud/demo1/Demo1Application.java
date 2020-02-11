package net.guides.springboot2.crud.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;


@SpringBootApplication
public class Demo1Application{
 
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	/*
	 * @Bean public MessageConverter jsonMessageConverter() { return new
	 * Jackson2JsonMessageConverter(); }
	 */
	 
	}


