package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Integer> {
	
	public List<Work> findByName(String name);
	public Long countByPhonenumber(String phonenumber);

}
