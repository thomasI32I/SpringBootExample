package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.IssueReport;


public interface IssueRepository extends JpaRepository<IssueReport, Long> {
	@Query(value = "SELECT i FROM IssueReport i WHERE markedAsPrivate = false")
    List<IssueReport> findAllButPrivate();

	//test command added
	List<IssueReport> findAllByEmail(String email);
}
