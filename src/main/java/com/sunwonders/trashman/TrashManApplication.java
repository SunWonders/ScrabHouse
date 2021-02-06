package com.sunwonders.trashman;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

// TODO: Auto-generated Javadoc
/**
 * The Class TrashManApplication.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class TrashManApplication extends SpringBootServletInitializer{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(TrashManApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	
//	@Bean
//	public MailSender mailSender() {
//	    return new MailSender();
//	}
}
