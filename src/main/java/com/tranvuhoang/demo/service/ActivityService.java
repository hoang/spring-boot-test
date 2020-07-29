package com.tranvuhoang.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tranvuhoang.demo.database.entity.Activity;
import com.tranvuhoang.demo.database.repository.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository repository;
	
	public List<Activity> findAll() {
		return repository.findAll();
	}
	
	public Activity create(Activity activity) {
		return repository.saveAndFlush(activity);
	}
	
}
