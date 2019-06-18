package com.hschoi.portfolio.project.service;

import com.hschoi.portfolio.project.entity.ProjectEntity;

/**
 * <pre>
 * com.hschoi.portfolio.project.service_ProjectService.java
 * </pre>
 * @date : 2019. 6. 17.
 * @author : hychoi
 */
public interface ProjectService {
	public ProjectEntity readByIdx(Long projectIdx);
}
