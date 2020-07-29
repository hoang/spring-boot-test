package com.tranvuhoang.demo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.tranvuhoang.demo.database.entity.lazy.User;
import lombok.Data;

@Data
public class UserDetailDto {

	private UUID id;
	private String name;
	private String email;
	private String phone;
	private TeamDto team;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	
	public UserDetailDto(User user, TeamDto team) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.team = team;
		this.created_at = user.getCreated_at();
		this.updated_at = user.getUpdated_at();
	}
	
}
