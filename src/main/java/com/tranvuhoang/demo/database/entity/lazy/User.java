package com.tranvuhoang.demo.database.entity.lazy;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tranvuhoang.demo.database.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper=false)
public class User extends BaseEntity{

	private String name;
	private String email;
	private String phone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	@JsonIgnore
	private Team team;
	
}
