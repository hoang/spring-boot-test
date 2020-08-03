package com.tranvuhoang.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tranvuhoang.demo.database.entity.lazy.Team;
import com.tranvuhoang.demo.database.entity.lazy.User;
import com.tranvuhoang.demo.database.repository.TeamRepository;
import com.tranvuhoang.demo.dto.TeamDetailDto;
import com.tranvuhoang.demo.dto.TeamDto;
import com.tranvuhoang.demo.dto.UserDto;
import com.tranvuhoang.demo.log.InjectLogger;

import javassist.NotFoundException;

@Service
public class TeamService {
	
	private static @InjectLogger Logger logger;

	@Autowired
	private TeamRepository repository;
	
	public Team create(Team team) {
		return repository.saveAndFlush(team);
	}
	
	public List<TeamDto> findAll() {
		List<Team> teams = repository.findAll();
		ArrayList<TeamDto> dtos = new ArrayList<TeamDto>();
		for (Team team: teams) {
			dtos.add(team.toDto());
		}
		return dtos;
	}
	
	@Transactional
	public TeamDetailDto findById(UUID id) throws NotFoundException {
		Optional<Team> optional = repository.findById(id);
		if (optional.isPresent()) {
			TeamDetailDto dto = null;
			Team team = optional.get();
			
			List<UserDto> userDtos = new ArrayList<>();
			for (User user: team.getUsers()) {
				userDtos.add(new UserDto(user));
			}
			
			dto = new TeamDetailDto(
				team.getId(), 
				team.getName(), 
				team.getDescription(), 
				team.getCreated_at(), 
				team.getUpdated_at(), 
				userDtos
			);
			return dto;
		} else {
			throw new NotFoundException("Team not found!");
		}
	}
	
}
