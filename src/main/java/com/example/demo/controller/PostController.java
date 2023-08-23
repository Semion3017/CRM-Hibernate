package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Post;
import com.example.demo.entity.Project;
import com.example.demo.service.PostService;

@RestController
public class PostController {
	
	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping(value = "/posts")
    public List<Post> getPosts() {
    	
    	return postService.getPosts();
    }
	
	@GetMapping(value = "/posts/{id}")
    public Post getPostById(@PathVariable long id) {
    	
    	return postService.getPostById(id);
    }
	
	@PostMapping(value = "/posts")
    public ResponseEntity<?> createPosts(@ModelAttribute Post post) {
		postService.createPosts(post);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

	@PutMapping(value = "/posts/{id}")
    public ResponseEntity<?> updatePosts(@PathVariable long id, @ModelAttribute Post post) {
		postService.updatePosts(id, post);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@DeleteMapping(value = "/posts/{id}")
    public ResponseEntity<?> deletePosts(@PathVariable long id) {
		postService.deletePosts(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
