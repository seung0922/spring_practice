package org.seung.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;
	
	@Test
	public void insertTest() {
		
		log.info("insert...............");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("제목");
		vo.setContent("내용");
		vo.setWriter("user00");
		
		log.info(vo);
		log.info(mapper.insert(vo));
		
	}
	
	@Test
	public void listPageTest() {
		
		log.info("getList...................");
		
		PageDTO dto = new PageDTO();
		dto.setKeyword("안녕");
		dto.setType("C");
		
		log.info(dto);
		log.info(mapper.listPage(dto));
		
	}
	
	@Test
	public void countPageTest() {
		
		log.info("countPage...............");
		
		PageDTO dto = new PageDTO();
		
		log.info(dto);
		log.info(mapper.countPage(dto));
	}
	
	@Test
	public void selectByBnoTest() {
		log.info("select by bno..................");
		
		PageDTO dto = new PageDTO();
		
		log.info(dto);
		dto.setBno(103);
		
		log.info(mapper.selectByBno(dto.getBno()));
	}
}
