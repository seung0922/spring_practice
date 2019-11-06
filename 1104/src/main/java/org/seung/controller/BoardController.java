package org.seung.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seung.domain.BoardVO;
import org.seung.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int amount,
			String keyword,
			String[] types,
			Model model) {
		
		log.info("list......." + page);
		log.info("list......." + amount);
		log.info("list......." + keyword);
		log.info("list......." + Arrays.toString(types));
		
		List<BoardVO> list = boardMapper.searchList(
				(page - 1) * 10,
				amount,
				keyword,
				types);
		
		log.info(list);
		
//		List<BoardVO> list = boardMapper.selectList((page - 1) * 10);
		model.addAttribute("list", list);
		
	}

	@GetMapping("/register")
	public void registerGET() {

	}

}
