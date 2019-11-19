package org.seung.mapper;

import org.junit.Test;
import org.seung.loading.LoadingTests;
import org.seung.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests extends LoadingTests {

	@Autowired
	private TimeMapper mapper;
	
	@Test
	public void testTime() {
		
		log.info(mapper.getTime());
		log.info(mapper.getTime2());
		
	}
}
