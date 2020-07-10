package com.sts.portal.repository;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.sts.portal.entity.City;
import com.sts.repository.BaseRepository;
public interface CityRepository extends BaseRepository<City, Long>{
	@RestResource(path="names")
	Optional<City> findByName(@Param("name")String name);
	
	@RestResource(exported = false)
	@Override
	void deleteById(Long id);
	
	@RestResource(exported =  false)
	@Override
	void delete(City entity);
}
