package com.sts.portal.projection;

import org.springframework.data.rest.core.config.Projection;

import com.sts.portal.entity.City;
import com.sts.portal.entity.State;

@Projection(types = {City.class},name = "customCity")
public interface CityProjection {
	Long getId(); 
	String getName();
	State getState();
}
