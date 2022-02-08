package com.example.service3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class Service2Controller {
	 @GetMapping("/statuscheck")
	    public String checkState() {
	        return "Service-B: inst002 Á¤»ó";
	    }
}
