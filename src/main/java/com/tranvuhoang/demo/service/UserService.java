package com.tranvuhoang.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranvuhoang.demo.database.entity.lazy.Team;
import com.tranvuhoang.demo.database.entity.lazy.User;
import com.tranvuhoang.demo.database.repository.UserRepository;
import com.tranvuhoang.demo.dto.MessageResponseDto;
import com.tranvuhoang.demo.dto.TeamDto;
import com.tranvuhoang.demo.dto.UserDetailDto;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public MessageResponseDto update(UUID id, UserDetailDto dto) {
		Optional<User> optional = repository.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			user.setPhone(dto.getPhone());
			return new MessageResponseDto("Update Success");
		} else {
			return new MessageResponseDto("User Not Found");
		}
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public UserDetailDto getById(UUID id, Optional<String> full) {
		Optional<User> optional = repository.findById(id);
		User user = optional.get();
		TeamDto teamDto = null;
		if (full.isPresent()) {
			Team team = user.getTeam();
			teamDto = new TeamDto(team.getId(), team.getName(), team.getDescription(), team.getCreated_at(), team.getUpdated_at());
		}
		return new UserDetailDto(user, teamDto);
	}
	
	public UserDetailDto create(UserDetailDto userDto) {
		User user = new User(
			userDto.getName(), 
			userDto.getEmail(), 
			userDto.getPhone(), 
			null
		);
		user = repository.saveAndFlush(user);
		return new UserDetailDto(user, null);
	}
	
}
