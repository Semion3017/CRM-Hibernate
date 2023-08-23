package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PostDAO;
import com.example.demo.entity.Post;
import com.example.demo.entity.Project;

@Service
public class PostService {
	
	private final PostDAO postDao;

	public PostService(PostDAO postDao) {
		this.postDao = postDao;
	}

	public List<Post> getPosts() {
		return postDao.getPosts();
	}

	public Post getPostById(long id) {
		return postDao.getPostById(id);
	}


	public void createPosts(Post post) {
		postDao.createPosts(post);
		
	}

	public void updatePosts(long id, Post post) {
		postDao.updatePosts(id, post);
		
	}

	public void deletePosts(long id) {
		postDao.deletePosts(id);
		
	}

}
