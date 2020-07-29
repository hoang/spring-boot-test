package com.tranvuhoang.demo.controllers;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranvuhoang.demo.dto.JwtResponseDto;
import com.tranvuhoang.demo.log.InjectLogger;
import com.tranvuhoang.demo.util.JwtUtil;

@RestController
@RequestMapping("/login")
public class LoginController {

	private static @InjectLogger Logger logger;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("")
	public JwtResponseDto login() {
		logger.info("calling gen-token api");
		String token = jwtUtil.generateJwt();
		return new JwtResponseDto(token);
	}
	
}
