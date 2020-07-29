package com.tranvuhoang.demo.database.repository_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.tranvuhoang.demo.database.entity.lazy.User;
import com.tranvuhoang.demo.database.repository.UserRepository;
import com.tranvuhoang.demo.database.repository.UserRepositoryAdvanced;

public class UserRepositoryAdvancedImpl implements UserRepositoryAdvanced {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Page<User> findAllOrderByIdPaging() {
		return userRepository.findAll(
			PageRequest.of(
				0, 2, Sort.by(Sort.Direction.DESC, "id")
			)
		);
	}

}
