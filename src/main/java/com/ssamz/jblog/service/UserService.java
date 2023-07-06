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

	public Optional<UserEntity> findById(long id) {
		return repository.findById(id + "");
	}

	public UserEntity save(UserEntity findUser) {
		return repository.save(findUser);
	}

	public void updateUser(UserEntity findUser, UserEntity user) {
		UserEntity oldUser = repository.findById(findUser.getId() + "").get();
		oldUser.setEmail(user.getEmail());
		oldUser.setPassword(user.getPassword());
		oldUser.setUsername(user.getUsername());
	}

	public void deleteById(Long id) {
		repository.deleteById(id + "");
		
	}

}
