package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.IssueReport;
import com.example.demo.repositories.IssueRepository;

/**
 * 
 * The @RestController annotation tells Spring that this is a RestController
 * and that the methods inside this controller should return JSON data.
 *
 */
@RestController
public class IssueRestController {
	IssueRepository issueRepository;
	
	/**
	 * Constructor
	 * The IssueRepository is automatically injected into the class.
	 * 
	 * @param issueRespository
	 */
    public IssueRestController(IssueRepository issueRespository) {
        this.issueRepository = issueRespository;
    }
	
    /**
     * 
     * @return
     */
    @GetMapping(value="/api/issues")
    public List<IssueReport> getIssues() {
        return this.issueRepository.findAllButPrivate();
    }

    /**
     * Access the variable id in the URL.
     * 
     * @param id
     * @return
     */
    @GetMapping(value="/api/issues/{id}")
    public IssueReport getIssue(@PathVariable(value="id") long id) {
        return this.issueRepository.getOne(id);
    }

}
