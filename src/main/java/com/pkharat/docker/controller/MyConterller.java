package com.pkharat.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyConterller {
	
	@GetMapping("/test-docker")
	public String getData() {
		return "in docker tutorial";
	}

}
