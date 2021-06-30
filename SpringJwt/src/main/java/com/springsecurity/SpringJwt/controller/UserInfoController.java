package com.springsecurity.SpringJwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.SpringJwt.entity.AuthenticationRequest;
import com.springsecurity.SpringJwt.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserInfoController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String welcome() {
		return "Hello Jwt Token";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			/*
			 * validating username and password
			 */
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));

		} catch (Exception e) {
			throw new Exception("invalid username/password");
		}
		return jwtUtil.generateToken(authenticationRequest.getUserName());
	}
}
