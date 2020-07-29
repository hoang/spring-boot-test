package com.tranvuhoang.demo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class TeamDto {

	private UUID id;
	private String name;
	private String description;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
}
