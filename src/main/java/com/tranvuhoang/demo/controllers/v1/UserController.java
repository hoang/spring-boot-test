package com.tranvuhoang.demo.controllers.v1;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tranvuhoang.demo.database.entity.lazy.User;
import com.tranvuhoang.demo.dto.MessageResponseDto;
import com.tranvuhoang.demo.dto.UserDetailDto;
import com.tranvuhoang.demo.service.UserService;

@RestController("User Controller Version 1")
@RequestMapping(path = "/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public List<User> getUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public UserDetailDto getUser(
			@PathVariable UUID id, 
			@RequestParam Optional<String> full
	) {
		return userService.getById(id, full);
	}
	
	@PostMapping("")
	public UserDetailDto createUser(@RequestBody UserDetailDto userDto) {
		return userService.create(userDto);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDto updateUser(
		@RequestBody UserDetailDto newUser, 
		@PathVariable UUID id
	) {
		return userService.update(id, newUser);
	}

}
