package com.hschoi.portfolio.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hschoi.portfolio.project.entity.ProjectEntity;
import com.hschoi.portfolio.project.repository.ProjectRepository;
import com.hschoi.portfolio.project.service.ProjectService;

/**
 * <pre>
 * com.hschoi.portfolio.project.service.impl_ProjectServiceImpl.java
 * </pre>
 * @date : 2019. 6. 17.
 * @author : hychoi
 */
@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public ProjectEntity readByIdx(Long projectIdx) {
		return projectRepository.findById(projectIdx).orElse(null);
	}

}
