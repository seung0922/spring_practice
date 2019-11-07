package org.seung.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seung.domain.BoardVO;
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
		vo.setTitle("제목이다앙");
		vo.setContent("근데 제가 졸린데 어떡하죠?");
		vo.setWriter("user00");
		
		log.info(vo);
		log.info(mapper.insert(vo));
		
	}
	
}
