package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Post;
import com.example.demo.entity.Project;

@Repository
public interface PostDAO {

	List<Post> getPosts();

	Post getPostById(long id);

	void createPosts(Post post);

	void updatePosts(long id, Post post);

	void deletePosts(long id);

}
