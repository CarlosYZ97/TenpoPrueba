package com.tenpo.prueba;

import com.tenpo.prueba.boot.config.cors.EnableCors;
import com.tenpo.prueba.boot.web.message.WebMessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableCors
@EnableAsync
@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		WebMessageSource messageSource = new WebMessageSource("default", 60, "classpath:i18n/messages", "classpath:i18n/messages-legacy");
		return messageSource;
	}


}
