package com.hschoi.portfolio.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * com.hschoi.portfolio.project.entity_ProjectEntity.java
 * </pre>
 * @date : 2019. 6. 17.
 * @author : hychoi
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectEntity {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectIdx;
	
	@Column
	@NotEmpty(message="타이틀을 입력해주세요.")
	@Size(max=100)
	private String projectName;
	
	@Column
	@NotEmpty(message="내용을 입력해주세요.")
	@Size(max=300)
	private String projectDescription;
	
	@Column
	@NotEmpty(message="이미지URL을 입력해주세요.")
	@Size(max=500)
	private String projectImg;
	
	@Column
	@NotEmpty(message="웹사이트 접속URL을 입력해주세요.")
	@Size(max=500)
	private String projectUrl;
	
	@Column
	private String adminEmail;
}
