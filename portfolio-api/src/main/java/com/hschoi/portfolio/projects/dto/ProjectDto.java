package com.hschoi.portfolio.projects.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hschoi.portfolio.projects.entity.Project;
import com.hschoi.portfolio.user.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <pre>
 * com.hschoi.portfolio.projects.dto_ProjectDto.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProjectDto {

	private long projectIdx;
	
	@NotNull
    @Size(min = 2, max = 100)
	private String projectName;
	
	@NotNull
	@Size(max = 500)
	private String projectDescription;

	@Size(max = 500)
	private String projectImg;
	
	@Size(max = 500)
	private String projectUrl;
	
	@NotNull
    @Size(min = 5, max = 20)
	private String userEmail;
	
	public ProjectDto(Long projectIdx, String projectName) {
        this.projectIdx = projectIdx;
        this.projectName = projectName;
    }
	
	public ProjectDto( String projectName, String userEmail) {
		this.projectName = projectName;
		this.userEmail = userEmail;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(projectName);
	}
	
	public Project toEntity() {
		return new Project( projectName, projectDescription, projectImg, projectUrl);
	}
}
