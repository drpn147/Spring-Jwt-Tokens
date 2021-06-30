package com.springsecurity.SpringJwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.SpringJwt.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	UserInfo findByUserName(String username);

}
