package org.seung.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seung.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Autowired
	private TimeMapper mapper;
	
	@Test
	public void testTime1() {
		
		log.info(mapper.getClass().getName());
		
		log.info(mapper.getTime1());
		
	}
	
	@Test
	public void testTime2() {
		
		log.info(mapper.getTime2());
		
	}
}
