package com.hschoi.portfolio.projects.service;

import com.hschoi.portfolio.projects.dto.ProjectDto;
import com.hschoi.portfolio.projects.entity.Project;

/**
 * <pre>
 * com.hschoi.portfolio.projects.service_ProjectService.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
public interface ProjectService {
	public ProjectDto register(ProjectDto project);
	public Project findByProjectName(String projectName);
	public Project findByIdx(long projectIdx);
}
