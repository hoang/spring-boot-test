package com.tranvuhoang.demo.controllers.v1;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranvuhoang.demo.database.entity.lazy.Team;
import com.tranvuhoang.demo.dto.TeamDetailDto;
import com.tranvuhoang.demo.service.TeamService;

import javassist.NotFoundException;

@RestController
@RequestMapping(path="/v1/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping("")
	public List<Team> getAll() {
		return teamService.findAll();
	}
	
	@GetMapping("/{id}")
	public TeamDetailDto getOne(@PathVariable UUID id) {
		try {
			return teamService.findById(id);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			return new TeamDetailDto();
		}
	}

	@PostMapping("")
	public Team create(@RequestBody Team team) {
		return teamService.create(team);
	}
	
}
