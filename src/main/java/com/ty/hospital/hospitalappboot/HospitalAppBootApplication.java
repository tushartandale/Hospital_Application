package com.ty.hospital.hospitalappboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HospitalAppBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAppBootApplication.class, args);																																									
	}
	
	@Bean
	public Docket getDocket() {
		Contact contact=new Contact("Tushar", "www.hospital.com", "info@hosp.com");
		
		List<VendorExtension> extensions=new ArrayList<VendorExtension>();
		
		ApiInfo apiInfo=new ApiInfo("Hospital App", "Heart Specialist Hospital", "SNPSHOT 1.0", "www.apollo.com", contact, "licence8978", "www.hospital.com", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ty"))
				.build()
				.apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
		
	}

}
