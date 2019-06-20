package com.hschoi.portfolio.projects.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hschoi.portfolio.projects.entity.Project;

/**
 * <pre>
 * com.hschoi.portfolio.projects.repository_ProjectRepository.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	Optional<Project> findByProjectName(String projectName);
	
//	@Query(value="select * from project where admin_email=?1", nativeQuery=true)
//	public List<Project> readAllByEmail(String email);
}
