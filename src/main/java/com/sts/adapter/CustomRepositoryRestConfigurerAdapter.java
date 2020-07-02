package com.sts.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.sts.entity.Country;
import com.sts.validator.CityValidator;
@Configuration
public class CustomRepositoryRestConfigurerAdapter implements RepositoryRestConfigurer {

	private static final String BEFORE_CREATE_EVENT = "beforeCreate";
	private static final String BEFORE_UPDATE_EVENT = "beforeUpdate";
	
	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
		validatingListener.addValidator(BEFORE_CREATE_EVENT, new CityValidator());
		validatingListener.addValidator(BEFORE_UPDATE_EVENT, new CityValidator());
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Country.class);		
	}
}
