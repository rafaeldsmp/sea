package br.com.xpto.csb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CsbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsbApplication.class, args);
	}

}
