package org.seung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {

	@GetMapping("/register")
	public void registerGET() {
		
		log.info("register get................");
		
	}
	
	@PostMapping("/register")
	public void registerPOST() {
		
		log.info("register post................");
		
	}
}
