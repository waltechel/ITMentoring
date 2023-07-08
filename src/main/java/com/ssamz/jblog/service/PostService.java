package com.ssamz.jblog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssamz.jblog.entity.PostEntity;
import com.ssamz.jblog.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	
	public void insertPost(PostEntity post) {
		post.setCnt(0);

		postRepository.save(post);
	}

	// 조회 내용 수정
	public List<PostEntity> getPostList() {
		return postRepository.findAll();
	}

	public PostEntity getPost(long id) {
		return postRepository.findById(id).get();
	}

	public void updatePost(PostEntity post) {
		PostEntity findPost = postRepository.findById(post.getId()).get();
		findPost.setTitle(post.getTitle());
		findPost.setContent(post.getContent());
		postRepository.save(findPost);
	}
}
