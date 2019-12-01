package org.seung.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seung.domain.ReplyVO;
import org.seung.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	private Integer[] bnoArr = {9, 8, 7, 6, 5};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void replyTest() {
		log.info(mapper.getListWithPaging2(9));
	}
	
	@Test
	public void testList2() {
		
		PageDTO pg = new PageDTO(1, 10);
		
		List<ReplyVO> replies = mapper.getListWithPaging(pg, 9);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	@Test
	public void testList() {
		
		PageDTO pg = new PageDTO();
		
		List<ReplyVO> replies = mapper.getListWithPaging(pg, bnoArr[1]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	@Test
	public void testUpdate() {
		Integer targetRno = 10;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("update reply");
		
		int count = mapper.update(vo);
		
		log.info("Update count: " + count);
	}
	
	@Test
	public void testDelete() {
		Integer targetRno = 9;
		
		mapper.delete(targetRno);
	}
	
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i->{
			
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글테스트" + i);
			vo.setReplyer("replyer" + i);
			vo.setByrno(5);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		Integer targetRno = 9;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info(vo);
	}
	
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
}
