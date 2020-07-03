package com.sts.repository;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.sts.entity.Location;

public interface LocationRepository extends BaseRepository<Location, Long>{
	Optional<Location> findByPincode(@Param("pincode") String pincode);
}
