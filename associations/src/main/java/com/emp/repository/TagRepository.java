package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.modal.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
