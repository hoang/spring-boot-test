package com.tranvuhoang.demo.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TeamDetailDto {

	private UUID id;
	private String name;
	private String description;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private List<UserDto> users;
	
}
