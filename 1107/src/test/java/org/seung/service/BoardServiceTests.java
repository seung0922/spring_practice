package org.seung.service;

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
public class BoardServiceTests {
	
	@Setter(onMethod_ = { @Autowired })
	private BoardService service;
	
	@Test
	public void registerTest() {
		
		log.info("service..............");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("service�׽�Ʈ");
		vo.setContent("�ٵ� ������ ����Ʈ�� �����?");
		vo.setWriter("user12");
		
		log.info(service.register(vo));
	}
	

}
