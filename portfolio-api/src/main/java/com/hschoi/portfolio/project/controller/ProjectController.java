package com.hschoi.portfolio.project.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hschoi.common.exception.InvalidAccessException;
import com.hschoi.portfolio.project.entity.ProjectEntity;
import com.hschoi.portfolio.project.service.ProjectService;

/**
 * <pre>
 * com.hschoi.portfolio.project_ProjectController.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("/api/v1")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@ResponseBody
	@RequestMapping(value="/project/{idx}", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public ProjectEntity projectReadByIdx(@PathVariable("idx") Long projectIdx) {
		
		// 프로젝트 정보 추출
		ProjectEntity proejct = projectService.readByIdx(projectIdx);
		
		// 사용자 권한 체크
//		if(!proejct.getAdminEmail().equals(principal.getName())){
//			throw new InvalidAccessException("InvalidAccess");
//		}
		
		return proejct;
	}
}
