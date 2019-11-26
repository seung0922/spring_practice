package org.seung.service;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seung.domain.ReplyVO;
import org.seung.dto.PageDTO;
import org.seung.mapper.ReplyMapper;
import org.seung.mapper.ReplyMapperTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {

	
private Integer[] bnoArr = {9, 8, 7, 6, 5};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyService mapper;
	
	@Test
	public void testList() {
		
		PageDTO pg = new PageDTO();
		
		List<ReplyVO> replies = mapper.getList(pg, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	@Test
	public void testUpdate() {
		Integer targetRno = 10;
		
		ReplyVO vo = mapper.get(targetRno);
		
		vo.setReply("히릴릴");
		
		int count = mapper.modify(vo);
		
		log.info("Update count: " + count);
	}
	
	@Test
	public void testDelete() {
		Integer targetRno = 8;
		
		mapper.remove(targetRno);
	}
	
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i->{
			
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글테스트" + i);
			vo.setReplyer("replyer" + i);
			
			mapper.register(vo);
		});
	}
	
	@Test
	public void testRead() {
		Integer targetRno = 8;
		
		ReplyVO vo = mapper.get(targetRno);
		
		log.info(vo);
	}
	
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
}
