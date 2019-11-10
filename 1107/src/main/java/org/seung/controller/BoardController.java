package org.seung.controller;

import javax.validation.Valid;

import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;
import org.seung.dto.PageMaker;
import org.seung.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String registerPOST(
			@ModelAttribute("vo") @Valid BoardVO vo,
			RedirectAttributes rttr,
			BindingResult bind) {
		
		log.info("register post................");
		
		// 에러가 있을 경우
		if(bind.hasErrors()) {
			log.info("error exiests");
			return "/board/register";
		}
		
		log.info(service.register(vo));
		
		// 잘 전송이 됐을 때 파라미터 보내줌
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/read")
	public void readGET(@ModelAttribute("dto") PageDTO dto, Model model) {
		
		log.info("read get..............");
		
		model.addAttribute("result", service.findByBno(dto.getBno()));
	}
	
	@PostMapping("/read")
	public String readPOST() {
		
		log.info("read post....................");
		
		return "redirect:/board/list";
	}
}
