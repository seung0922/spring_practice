package org.seung.controller;

import java.util.List;

import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;
import org.seung.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board2/*")
@RestController
@Log4j
public class BoardRESTController {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;
	
	@PostMapping("/")
	public boolean register(@RequestBody BoardVO vo) {
		// 객체형으로 주면 json 등으로 나옴
		log.info(vo);
		
		return service.register(vo);
	}
	
	@GetMapping("/{bno}")
	public BoardVO read(@PathVariable("bno") Integer bno) {
		return service.findByBno(bno);
	}
	
	@CrossOrigin
	@GetMapping("/list1")
	public List<BoardVO> list1() {
		PageDTO dto = new PageDTO();
		return service.getList(dto);
	}
	
}
