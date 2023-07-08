package com.ssamz.jblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssamz.jblog.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);

}
