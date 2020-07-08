package com.sts.repository;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.sts.entity.User;

public interface UserRepository extends BaseRepository<User, Long>{
	Optional<User> findByUsername(@Param("username") String username);
	Optional<User> findByEmail(@Param("email") String email);
}
