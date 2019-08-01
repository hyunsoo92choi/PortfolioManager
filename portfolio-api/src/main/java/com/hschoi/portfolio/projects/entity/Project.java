package com.hschoi.portfolio.projects.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.hschoi.common.entity.BaseEntity;
import com.hschoi.portfolio.projects.dto.ProjectDto;
import com.hschoi.portfolio.user.entity.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * com.hschoi.portfolio.projects.entity_ProjectEntity.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table( name="project")
public class Project extends BaseEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectIdx;
	
	@Column
	@NotEmpty(message="타이틀을 입력해주세요.")
	@Size(min = 2, max = 100)
	private String projectName;
	
	@Column
	@NotEmpty(message="내용을 입력해주세요.")
	@Size(max=500)
	private String projectDescription;
	
	@Column
	@Size(max=500)
	private String projectImg;
	
	@Column
	@Size(max=500)
	private String projectUrl;
	
	@ManyToOne
    @JoinColumn(name = "user_email", nullable = false, updatable = false)
    private User user;
	
	public Project(String projectName, String projectDescription, String projectImg, String projectUrl) {
		
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectImg = projectImg;
		this.projectUrl = projectUrl;
	}
	
	public ProjectDto toProjectDto() {
        return new ProjectDto(projectIdx, projectName);
    }
	
}
