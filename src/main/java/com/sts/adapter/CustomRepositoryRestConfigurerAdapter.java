package com.sts.adapter;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.sts.course.entity.Course;
import com.sts.course.entity.CourseCategory;
import com.sts.course.entity.CourseContent;
import com.sts.portal.entity.City;
import com.sts.portal.entity.Country;
import com.sts.portal.entity.Location;
import com.sts.portal.entity.State;

@Configuration
public class CustomRepositoryRestConfigurerAdapter implements RepositoryRestConfigurer {

	private static final String BEFORE_CREATE_EVENT = "beforeCreate";
	private static final String BEFORE_UPDATE_EVENT = "beforeUpdate";

	@Bean
	@Primary
	/**
	 * Create a validator to use in bean validation - primary to be able to autowire without qualifier
	 */
	public Validator validator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	    validator.setValidationMessageSource(messageSource());
		return validator;
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource= new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	
	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
		Validator validator = validator();
		validatingListener.addValidator(BEFORE_CREATE_EVENT, validator);
		validatingListener.addValidator(BEFORE_UPDATE_EVENT, validator);
		
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Country.class,State.class,City.class,Location.class, 
				Course.class, CourseCategory.class,CourseContent.class);
	}
	
	
}
