package com.sts.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
@Configuration
@EnableSwagger2WebMvc
@Import({ SpringDataRestConfiguration.class , BeanValidatorPluginsConfiguration.class })
public class SpringFoxConfig {
	
	private static final Contact CONTACT = new Contact("Bhagyashree Chavan", "www.sts.in", "bhagyashree.chavan@sts.in");
	
	private static final ApiInfo API_INFO=new ApiInfo("spring-data-rest", "Swagger Doc for Spring Data Rest", "1.0.0", 
			null, CONTACT, null, null, Collections.emptyList());
	
	@Value("${server.servlet.context-path}")
    private String contextPath;
	
	private static final String EMPTY_STRING="";
	
	private final PathProvider customPathProvider = new PathProvider() {		
		@Override
		public String getResourceListingPath(String groupName, String apiDeclaration) {
			return null;
		}
		
		@Override
		public String getOperationPath(String operationPath) {
			return operationPath.replace(contextPath, EMPTY_STRING);
		}
	};
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.pathProvider(customPathProvider)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(API_INFO)
				.useDefaultResponseMessages(false);				
	}
	
}
