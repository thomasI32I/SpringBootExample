package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.IssueReport;


/**
 * Interface which serves as database interface. The used Java SQL database is h2.
 *
 */
public interface IssueRepository extends JpaRepository<IssueReport, Long> {
	
	@Query(value = "SELECT i FROM IssueReport i WHERE markedAsPrivate = false")
    List<IssueReport> findAllButPrivate();
	
	List<IssueReport> findAllByEmail(String email);
}
