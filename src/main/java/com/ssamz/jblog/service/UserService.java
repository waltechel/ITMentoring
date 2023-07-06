package com.ssamz.jblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ssamz.jblog.entity.UserEntity;
import com.ssamz.jblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;

	public List<UserEntity> getAllUser() {
		List<UserEntity> ret = new ArrayList<>();
		ret.add(UserEntity.builder().username("dongjun").email("email").build());
		return ret;
	}

	public UserEntity getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertUser(UserEntity user) {
		// TODO Auto-generated method stub
		
	}

	public Optional<UserEntity> findById(String id) {
		return repository.findById(id);
	}

}
