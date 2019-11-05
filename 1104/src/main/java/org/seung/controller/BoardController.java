package org.seung.controller;

import java.util.List;

import org.seung.domain.BoardVO;
import org.seung.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Setter;

@Controller
@RequestMapping("board/*")
public class BoardController {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	@GetMapping("/list")
	public void selectList(@RequestParam(defaultValue = "1") int page, Model model) {
		List<BoardVO> list = boardMapper.selectList((page - 1) * 10);
		model.addAttribute("list", list);
	}

	@GetMapping("/register")
	public void registerGET() {

	}

	@PostMapping("/register")
	public String registerPOST(@RequestParam("title") String title, 
			@RequestParam("content") String content,
			@RequestParam("writer") String writer, 
			RedirectAttributes rttr) {

		BoardVO vo = new BoardVO();

		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);

		boardMapper.insert(vo);

		rttr.addFlashAttribute("result", vo.getBno());

		return "redirect:/board/list";

	}
}
