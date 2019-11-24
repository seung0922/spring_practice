package org.seung.service;

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
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void registertests() {
		BoardVO vo = new BoardVO();
		
		for(int i=1; i<101; i++) {
			vo.setTitle("title" + i);
			vo.setContent("content" + i);
			vo.setWriter("writer" + i);
		}
		
	}
	
	@Test
	public void deleteTests() {
		
		log.info(service.delete(3));
	}
	
	
//	@Test
//	public void searchListTests() {
//		PageDTO dto = new PageDTO();
//		
//		dto.setKeyword("5");
//		dto.setType("C");
//		
//		log.info(service.searchList(dto));
//	}
}
