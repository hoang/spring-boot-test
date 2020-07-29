package com.tranvuhoang.demo.database.entity.lazy;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tranvuhoang.demo.database.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_team")
@Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Team extends BaseEntity {

	private String name;
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
	@JsonIgnore
	private List<User> users;
	
}

