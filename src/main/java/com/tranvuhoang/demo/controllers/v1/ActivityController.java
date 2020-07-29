package com.tranvuhoang.demo.controllers.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping("")
	public Activity createActivity(@RequestBody Activity activity) {
		return service.create(activity);
	}
	
}
