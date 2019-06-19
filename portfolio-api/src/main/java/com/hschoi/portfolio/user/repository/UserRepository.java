package com.hschoi.portfolio.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hschoi.portfolio.user.entity.User;

/**
 * <pre>
 * com.hschoi.portfolio.user.repository_UserRepository.java
 * </pre>
 * @date : 2019. 6. 18.
 * @author : hychoi
 */
@Repository(value = "UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserEmail(String userEmail);
}
