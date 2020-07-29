package com.tranvuhoang.demo.unit_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tranvuhoang.demo.database.entity.lazy.Team;
import com.tranvuhoang.demo.database.entity.lazy.User;
import com.tranvuhoang.demo.database.repository.UserRepository;
import com.tranvuhoang.demo.dto.UserDetailDto;
import com.tranvuhoang.demo.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository repository;
	
	private String idStr = "f147f610-69fc-4881-8d8f-62ce22eb9a64";

	@BeforeEach
	void setUp() {
		Team team = new Team("venus", "bpm team", null);
		User user = new User("tombeo", "tombeo@gmail.com", "0389004032", team);
		Mockito.when(repository.findById(UUID.fromString(idStr)))
			.thenReturn(Optional.of(user));
	}
	
	@Test
	void testFindById() {
		UserDetailDto dto = userService.getById(UUID.fromString(idStr), Optional.empty());
		assertEquals(dto.getName(), "tombeo");
		assertNull(dto.getTeam());
	}
	
	@Test
	void testFindByIdFullDetail() {
		UserDetailDto dto = userService.getById(UUID.fromString(idStr), Optional.of("full"));
		assertEquals(dto.getName(), "tombeo");
		assertEquals(dto.getTeam().getName(), "venus");
	}
	
}
