package com.springsecurity.SpringJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.springsecurity.SpringJwt.entity.UserInfo;
import com.springsecurity.SpringJwt.repository.UserInfoRepository;

@SpringBootApplication
public class SpringJwtApplication {

	@Autowired
	private UserInfoRepository userInfoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}

	void initUsers() {
		UserInfo user = new UserInfo(1, "root", "root@123", "root@jwt.com");
		this.userInfoRepository.save(user);
	}

}
