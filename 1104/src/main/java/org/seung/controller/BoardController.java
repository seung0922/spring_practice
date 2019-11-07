package org.seung.controller;

import java.util.Arrays;
import java.util.List;

import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;
import org.seung.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("board/*")
@Log4j
@AllArgsConstructor
public class BoardController {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	@GetMapping("/list")
	public void searchList(
			@ModelAttribute("dto") PageDTO dto, Model model) {
		
		log.info(dto);
		
		List<BoardVO> list = boardMapper.searchList(dto);
		
		model.addAttribute("list", list);
		
	}

	@GetMapping("/register")
	public void registerGET() {

	}

}
