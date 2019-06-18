package com.hschoi.portfolio.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hschoi.portfolio.project.entity.ProjectEntity;

/**
 * <pre>
 * com.hschoi.portfolio.project.repository_ProjectRepository.java
 * </pre>
 * @date : 2019. 6. 17.
 * @author : hychoi
 */
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}
