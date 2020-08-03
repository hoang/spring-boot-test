package com.tranvuhoang.demo.controllers.v1;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranvuhoang.demo.database.entity.Activity;
import com.tranvuhoang.demo.service.ActivityService;

@RestController("Activity Controller Version 1")
@RequestMapping(path = "/v1/activities")
public class ActivityController {
	
	@Autowired
	private ActivityService service;
	
	@GetMapping("")
	public List<Activity> getAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Activity getOne(@PathVariable UUID id) {
		Optional<Activity> activity = service.findById(id);
		return activity.get();
	}

	@PostMapping("")
	public Activity createActivity(@RequestBody Activity activity) {
		return service.create(activity);
	}
	
}
