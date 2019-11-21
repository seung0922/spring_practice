package org.seung.controller;

import java.util.Arrays;
import java.util.UUID;

import javax.validation.Valid;

import org.seung.domain.BoardAttachVO;
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

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/register")
	public void registerGET() {
		log.info("Get register........................");
	}

	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo") @Valid BoardVO vo, BindingResult bind, RedirectAttributes rttr) {

		log.info("post register......................");
		log.info(vo);
		
		service.register(vo);

		return "redirect:/board/list";

	}

	@GetMapping("/list")
	public void listGET(@ModelAttribute("dto") PageDTO dto, Model model) {

		log.info("list get................");

		int total = service.getCount(dto);

		PageMaker pg = new PageMaker(total, dto);

		log.info(pg);

		model.addAttribute("pg", pg);
		model.addAttribute("list", service.getList(dto));

	}

	@GetMapping("/read")
	public void readGET(@ModelAttribute("dto") PageDTO dto,	Model model) {
		log.info("read get...................");

		model.addAttribute("result", service.selectByBno(dto.getBno()));
		model.addAttribute("fileList", service.getAttachList(dto.getBno()));
	}

	@GetMapping("/delete")
	public String deleteGET(RedirectAttributes rttr, PageDTO dto, Model model) {
		log.info("delete get.............");

		service.delete(dto.getBno());

		rttr.addAttribute("page", dto.getPage());
		rttr.addAttribute("amount", dto.getAmount());

		return "redirect:/board/list";
	}

	@GetMapping("/update")
	public void updateGET(@ModelAttribute("dto") PageDTO dto, Model model) {

		log.info("update get.......................");

		model.addAttribute("result", service.selectByBno(dto.getBno()));
	}

	@PostMapping("/update")
	public String updatePOST(RedirectAttributes rttr, PageDTO dto, BoardVO vo) {

		log.info("update post.......................");

		log.info(service.update(vo));

		log.info(dto);

		rttr.addAttribute("bno", dto.getBno());
		rttr.addAttribute("page", dto.getPage());
		rttr.addAttribute("amount", dto.getAmount());

//		rttr.addAttribute("dto", dto);

		return "redirect:/board/read";
	}

}