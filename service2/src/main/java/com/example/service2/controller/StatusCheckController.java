package com.example.service2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class StatusCheckController {
	 @GetMapping("/statuscheck")
	    public String checkState() {
	        return "Service-B: inst001 Á¤»ó";
	    }
}
