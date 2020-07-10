package com.sts.portal.repository;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sts.portal.entity.Country;
import com.sts.portal.projection.CountryProjection;
import com.sts.repository.BaseRepository;
/**
 * NOTE: excerpts apply automatically only to collection resources
 * @author bhagyashree.chavan
 *
 */

@RepositoryRestResource(excerptProjection = CountryProjection.class)
public interface CountryRepository extends BaseRepository<Country, Long>{
	Optional<Country> findByName(@Param("name") String name);
}
