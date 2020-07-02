package com.sts.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sts.entity.City;

public class CityValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return City.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final City city = (City) target;
		if(city.getName().isBlank())
			errors.rejectValue("name", "name.empty");
	}

}
