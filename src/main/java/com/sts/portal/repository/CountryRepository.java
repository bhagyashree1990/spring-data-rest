package com.sts.portal.repository;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.sts.portal.entity.Country;
import com.sts.repository.BaseRepository;

public interface CountryRepository extends BaseRepository<Country, Long>{
	Optional<Country> findByName(@Param("name") String name);
}
