package com.sts.portal.projection;

import org.springframework.data.rest.core.config.Projection;

import com.sts.portal.entity.Country;
import com.sts.portal.entity.State;

@Projection(types = {State.class},name="customState")
public interface StateProjection {
	Long getId();
	String getName();
	Country getCountry();
}
