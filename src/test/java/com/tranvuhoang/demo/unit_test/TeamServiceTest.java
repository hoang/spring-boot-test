package com.tranvuhoang.demo.unit_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tranvuhoang.demo.database.entity.lazy.Team;
import com.tranvuhoang.demo.database.repository.TeamRepository;
import com.tranvuhoang.demo.dto.TeamDetailDto;
import com.tranvuhoang.demo.dto.TeamDto;
import com.tranvuhoang.demo.log.InjectLogger;
import com.tranvuhoang.demo.service.TeamService;

import javassist.NotFoundException;

@SpringBootTest
class TeamServiceTest {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private static @InjectLogger Logger logger;
	
	@MockBean
	private TeamRepository repository;
	
	private final String idStr = "f147f610-69fc-4881-8d8f-62ce22eb9a64";
	private final String idStrNotFound = "f147f610-69fc-4881-8d8f-62ce22eb9a68";
	
	@BeforeEach
	void setUp() {
		Team team = new Team("venus", "bpm team", new ArrayList<>());
		Mockito.when(repository.findById(UUID.fromString(idStr)))
			.thenReturn(Optional.of(team));
		
		Mockito.when(repository.findById(UUID.fromString(idStrNotFound)))
			.thenReturn(Optional.empty());

		Mockito.when(repository.saveAndFlush(Mockito.any(Team.class)))
			.thenReturn(team);
		
		ArrayList<Team> teams = new ArrayList<>();
		teams.add(team);
		Mockito.when(repository.findAll())
			.thenReturn(teams);
	}

	@Test
	void testFindById() throws NotFoundException {
		TeamDetailDto dto = teamService.findById(UUID.fromString(idStr));
		assertEquals(dto.getName(), "venus");
		
		boolean hasException = false;
		try {
			dto = teamService.findById(UUID.fromString(idStrNotFound));
		} catch (NotFoundException e) {
			hasException = true;
			assertEquals(e.getClass(), NotFoundException.class);
		}
		assertTrue(hasException);
	}

	@Test
	void testCreate() {
		Team team = teamService.create(new Team());
		assertEquals(team.getName(), "venus");
	}
	
	@Test
	void testFindAll() {
		List<TeamDto> dtos = teamService.findAll();
		assertEquals(dtos.get(0).getName(), "venus");
	}

}
