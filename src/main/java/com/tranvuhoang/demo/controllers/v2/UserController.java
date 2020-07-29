package com.tranvuhoang.demo.controllers.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranvuhoang.demo.dto.MessageResponseDto;

@RestController("User Controller Version 2")
@RequestMapping("/v2/users")
public class UserController {

	@GetMapping("")
	public MessageResponseDto welcomeV2() {
		return new MessageResponseDto("this is api users v2");
	}
	
}
