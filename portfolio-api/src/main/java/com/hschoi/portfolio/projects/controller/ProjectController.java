package com.hschoi.portfolio.projects.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hschoi.portfolio.projects.dto.ProjectDto;
import com.hschoi.portfolio.projects.service.ProjectService;

/**
 * <pre>
 * com.hschoi.portfolio.projects.controller_ProjectController.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
	
	private final Logger log = LoggerFactory.getLogger(ProjectController.class);
	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@PostMapping("/register")
    public ResponseEntity<ProjectDto> register(@Valid @RequestBody ProjectDto projectDto) {
        
		log.info("프로젝트 등록 : {}", projectDto);
		ProjectDto project = projectService.register(projectDto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }
}
