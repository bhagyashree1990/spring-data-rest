package com.sts.portal.repository;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.sts.portal.entity.State;
import com.sts.repository.BaseRepository;

public interface StateRepository extends BaseRepository<State, Long>{
	Optional<State> findByName(@Param("name")String name);
}
