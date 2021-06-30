package com.springsecurity.SpringJwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.SpringJwt.entity.UserInfo;
import com.springsecurity.SpringJwt.repository.UserInfoRepository;

@Service
public class CustomeUserInfoService implements UserDetailsService {

	@Autowired
	private UserInfoRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user=this.repository.findByUserName(username);
		return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
	}

	
}
