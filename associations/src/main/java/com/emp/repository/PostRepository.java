package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.modal.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
