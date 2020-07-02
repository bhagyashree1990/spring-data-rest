package com.sts.entity;

import org.springframework.data.rest.core.config.Projection;
/**
 * NOTE: we need to define our Projection in the same package as our models. 
 * @author bhagyashree.chavan
 *
 */
@Projection(types = {City.class},name = "customCity")
public interface CityProjection {
	Long getId(); 
	String getName();
	State getState();
}
