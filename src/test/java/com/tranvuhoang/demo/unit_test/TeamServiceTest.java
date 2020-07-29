package com.tranvuhoang.demo.unit_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tranvuhoang.demo.database.entity.lazy.Team;
import com.tranvuhoang.demo.database.repository.TeamRepository;
import com.tranvuhoang.demo.dto.TeamDetailDto;
import com.tranvuhoang.demo.log.InjectLogger;
import com.tranvuhoang.demo.service.TeamService;

import javassist.NotFoundException;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class TeamServiceTest {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private static @InjectLogger Logger logger;
	
	@MockBean
	private TeamRepository repository;
	
	private final String idStr = "f147f610-69fc-4881-8d8f-62ce22eb9a64";
	private final String idStrNotFound = "f147f610-69fc-4881-8d8f-62ce22eb9a68";
	
	@BeforeAll
	void setUp() {
		Team team = new Team("venus", "bpm team", new ArrayList<>());
		Mockito.when(repository.findById(UUID.fromString(idStr))).
			thenReturn(Optional.of(team));
		
		Mockito.when(repository.findById(UUID.fromString(idStrNotFound)))
			.thenReturn(Optional.empty());
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

}
