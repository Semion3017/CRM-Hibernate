package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Post;
import com.example.demo.entity.Project;
import com.example.demo.util.UtilsHiber;

@Repository
public class PostDaoImpl implements PostDAO{

	@Override
	public List<Post> getPosts() {
		String query = "select p from Post p";
		try(Session session = UtilsHiber.getSession()){
				session.beginTransaction();
				List<Post> postList = session.createQuery(query, Post.class).getResultList();
				session.getTransaction().commit();
			
		return postList;
		}
	}

	@Override
	public Post getPostById(long id) {
		try(Session session = UtilsHiber.getSession()){
			session.beginTransaction();
			Post post = session.get(Post.class, id);
			session.getTransaction().commit();
		return post;
		}
	}

	@Override
	public void createPosts(Post post) {
		try(Session session = UtilsHiber.getSession()){
			session.beginTransaction();
			session.persist(post);
			session.getTransaction().commit();
		}
		
	}

	@Override
	public void updatePosts(long id, Post postWithUpdates) {
		try(Session session = UtilsHiber.getSession()){
			session.beginTransaction();
			Post postBeforeUpdate = session.get(Post.class, id);
			if (postBeforeUpdate == null) {
				session.getTransaction().commit();
			} else {
			if(postWithUpdates.getTitle() == null) 
				postWithUpdates.setTitle(postBeforeUpdate.getTitle());
			session.merge(postWithUpdates);
			session.getTransaction().commit();
			}
	}
		
	}

	@Override
	public void deletePosts(long id) {
		try (Session session = UtilsHiber.getSession()) {
			session.beginTransaction();
			Post post = session.get(Post.class, id);
			if (post == null) {
				session.getTransaction().commit();
			} else {
				session.remove(post);
				session.getTransaction().commit();
			}
		}
		
	}

}
