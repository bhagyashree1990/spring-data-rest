package com.sts.portal.repository;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.sts.portal.entity.Location;
import com.sts.repository.BaseRepository;

public interface LocationRepository extends BaseRepository<Location, Long>{
	Optional<Location> findByPincode(@Param("pincode") String pincode);
}
