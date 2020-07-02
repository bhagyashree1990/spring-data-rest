package com.sts.repository;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.sts.entity.State;

public interface StateRepository extends BaseRepository<State, Long>{
	Optional<State> findByName(@Param("name")String name);
}
