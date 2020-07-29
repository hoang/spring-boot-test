package com.tranvuhoang.demo.database.repository;

import org.springframework.data.domain.Page;

import com.tranvuhoang.demo.database.entity.lazy.User;

public interface UserRepositoryAdvanced {

	public Page<User> findAllOrderByIdPaging();
	
}
