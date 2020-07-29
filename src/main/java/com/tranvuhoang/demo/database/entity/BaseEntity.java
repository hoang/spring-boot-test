package com.tranvuhoang.demo.database.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class BaseEntity {
	
	@Id @Type(type = "pg-uuid") @Getter @Setter
	private UUID id;
	
	public BaseEntity() {
        this.id = UUID.randomUUID();
    }

	@Getter @CreationTimestamp
	private LocalDateTime created_at;

	@Getter @UpdateTimestamp
	private LocalDateTime updated_at;
}
