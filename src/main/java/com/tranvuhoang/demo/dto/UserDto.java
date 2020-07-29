package com.tranvuhoang.demo.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import com.tranvuhoang.demo.database.entity.lazy.User;
import lombok.Data;

@Data
public class UserDto {

	private UUID id;
	private String name;
	private String email;
	private String phone;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;

	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.created_at = user.getCreated_at();
		this.updated_at = user.getUpdated_at();
	}
	
}
