package org.seung.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seung.domain.BoardAttachVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AttachMapperTests {
	
	@Autowired
	private AttachMapper mapper;
	
	@Test
	public void insertAttachTests() {
		
		log.info("insert attach..................");
		
		BoardAttachVO vo = new BoardAttachVO();
		
		vo.setFileName("aaa.jpg");
		vo.setBno(100);
		
		mapper.insertAttach(vo);
	}
	
	@Test
	public void selectFileList() {
		log.info("file........list..........");
		
		log.info(mapper.selectAttachList(234));
	}

}
