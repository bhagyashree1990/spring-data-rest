package com.sts.projection;

import org.springframework.data.rest.core.config.Projection;

import com.sts.entity.Country;
import com.sts.entity.State;

@Projection(types = {State.class},name="customState")
public interface StateProjection {
	Long getId();
	String getName();
	Country getCountry();
}
