package com.tranvuhoang.demo.database.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_activity")
@Data @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
public class Activity extends BaseEntity {

	private UUID user_id;
	private String action;
	
}
