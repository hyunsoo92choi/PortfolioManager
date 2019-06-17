package com.hschoi.portfolio.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hschoi.portfolio.admin.entity.AdminEntity;

/**
 * <pre>
 * com.hschoi.portfolio.admin.repository_AdminRepository.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String> {

}
