package com.airtomaintain.maintenance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceController {
	
	@GetMapping("sayHello")
	public String sayHello() {
		return "Hi World";
	}

}
