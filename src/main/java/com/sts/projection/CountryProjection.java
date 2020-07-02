package com.sts.projection;

import org.springframework.data.rest.core.config.Projection;

import static com.sts.adapter.CustomWebMvcConfigurerAdapter.STATIC_URL;
import com.sts.entity.Country;

@Projection(types = {Country.class},name = "customCountry")
public interface CountryProjection {
	Long getId();
	String getName();
	
	public default String getFlag() {
		String baseUrl = STATIC_URL + "/images/flags/";
		String imagePrefix="flag-of-";
		String imageSuffix=".jpg";
		return baseUrl+imagePrefix+getName()+imageSuffix;
	}
}
