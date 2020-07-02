package com.sts.repository;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.sts.entity.Country;

public interface CountryRepository extends BaseRepository<Country, Long>{
	Optional<Country> findByName(@Param("name") String name);
}
