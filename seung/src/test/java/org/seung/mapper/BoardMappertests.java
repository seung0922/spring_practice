package org.seung.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMappertests {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void insertTest() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("하이");
		vo.setContent("하이루");
		vo.setWriter("궁쌤");
		log.info(mapper.insert(vo));
	}
	
	@Test
	public void getListTest() {
		
		PageDTO dto = new PageDTO();
		dto.setAmount(2);
		
		log.info(mapper.getList(dto));
		
	}
	
	@Test
	public void selectBnotest() {
		log.info(mapper.selectByBno(3));
	}
	
	@Test
	public void deleteTest() {
		log.info(mapper.delete(2));
	}
	
	@Test
	public void updateTest() {
		BoardVO vo = mapper.selectByBno(106);
		
		vo.setTitle("수정제목");
		vo.setContent("수정내용");
		vo.setWriter("수정작성자");
		
		mapper.update(vo);
	}
	
	@Test
	public void getCountTests() {
		PageDTO dto = new PageDTO();
		
		log.info(mapper.getCount(dto));
	}
	
	@Test
	public void searchListTests() {
		PageDTO dto = new PageDTO();
		
		dto.setKeyword("5");
		dto.setType("C");
		
		log.info(mapper.searchList(dto));
	}
}
