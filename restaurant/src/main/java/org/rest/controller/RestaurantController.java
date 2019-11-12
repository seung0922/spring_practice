package org.rest.controller;

import org.rest.domain.RestVO;
import org.rest.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RequestMapping(value = "/rest/*", produces = "text/json;charset=UTF-8")
@RestController
@Log4j
public class RestaurantController {
	
	@Setter(onMethod_ = @Autowired)
	private RestService service;
	
	@CrossOrigin
	@GetMapping("/list")
	public ResponseEntity<String> list(RestVO vo){
		log.info("map............");
		
//		log.info(category);
		
		String jsonData = new Gson().toJson(service.getList());
		
		log.info(jsonData);
		
		return new ResponseEntity<String>(jsonData, HttpStatus.OK);
	}
}
