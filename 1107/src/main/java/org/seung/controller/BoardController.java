package org.seung.controller;

import org.seung.domain.BoardVO;
import org.seung.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Setter(onMethod_ = { @Autowired } )
	private BoardService service;

	@GetMapping("/register")
	public void registerGET() {
		
		log.info("register get................");
		
	}
	
	@PostMapping("/register")
	public String registerPOST(BoardVO vo) {
		
		log.info("register post................");
		log.info(vo);
		
		
		log.info(service.register(vo));
		
		return "redirect:/board/list";
		
	}
}
