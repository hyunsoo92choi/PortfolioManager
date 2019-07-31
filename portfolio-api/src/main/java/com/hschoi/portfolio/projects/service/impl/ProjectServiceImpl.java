package com.hschoi.portfolio.projects.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hschoi.common.exception.CustomException;
import com.hschoi.portfolio.projects.dto.ProjectDto;
import com.hschoi.portfolio.projects.entity.Project;
import com.hschoi.portfolio.projects.repository.ProjectRepository;
import com.hschoi.portfolio.projects.service.ProjectService;
import com.hschoi.portfolio.user.repository.UserRepository;

import static com.hschoi.common.code.httpstatus.HttpStatusType.PROJECT_NOT_FOUND;

/**
 * <pre>
 * com.hschoi.portfolio.projects.service.impl_ProjectServiceImpl.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	private final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	private final ProjectRepository projectRepository;
	private final UserRepository userRepository;
	
	public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository) {
		this.projectRepository = projectRepository;
		this.userRepository = userRepository;
	}
	
	@Override
	public ProjectDto register(ProjectDto project) {
		
		log.info("프로젝트 등록 : {}", project);
		verifyExist(project);
		
		return projectRepository.save(project.toEntity()).toProjectDto();
	}

	@Override
	public Project findByIdx(long projectIdx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void verifyExist(ProjectDto project) {
        
		// 동일한 프로젝트 중복생성 체크
		if (projectRepository.findByProjectName(project.getProjectName()).isPresent()) {
            throw new CustomException(PROJECT_NOT_FOUND);
        }
	}

	@Override
	public Project findByProjectName(String projectName) {
		return projectRepository.findByProjectName(projectName)
				.orElseThrow(() -> new CustomException(PROJECT_NOT_FOUND));
	}

}
