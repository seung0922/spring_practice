package org.rest.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class mapperTest {
	
	@Autowired
	private RestMapper mapper;
	
	@Test
	public void mapperTest() {
		log.info(mapper.getList());
		String jsonData = new Gson().toJson(mapper.getList());
		log.info("Data : " + jsonData);
	} 
}
