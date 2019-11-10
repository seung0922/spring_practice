package org.seung.controller;

import java.util.List;

import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;
import org.seung.dto.PageMaker;
import org.seung.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("/list")
	public void listGET(PageDTO dto, Model model) {
		
		log.info("list get...............");
		log.info(dto);
		
		model.addAttribute("list", service.getList(dto));
		
		int total = service.getListCount(dto);
		PageMaker pg = new PageMaker(dto, total);
		
		log.info(pg);
		
		model.addAttribute("pg", pg);
	}

	@GetMapping("/register")
	public void registerGET() {
		
		log.info("register get................");
		
	}
	
	@PostMapping("/register")
	public String registerPOST(BoardVO vo) {
		
		log.info("register post................");
		
		service.register(vo);
		
		return "redirect:/board/list";
	}
}
