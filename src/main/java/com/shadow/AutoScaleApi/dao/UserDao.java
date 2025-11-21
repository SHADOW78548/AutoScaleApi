package com.shadow.AutoScaleApi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shadow.AutoScaleApi.dto.UserResponse;
import com.shadow.AutoScaleApi.model.UserInfo;
@Repository
public interface UserDao extends JpaRepository<UserInfo, Long> {
	 Optional<UserInfo> findById(Long id);
	 UserInfo findByName(String name);
}
