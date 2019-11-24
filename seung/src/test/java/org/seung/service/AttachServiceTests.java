package org.seung.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AttachServiceTests {

	@Autowired
	private AttachService attachservice;
	
	@Test
	public void deleteFileTest() {
		log.info("del file................");
		
		log.info(attachservice.deleteFile("b828b809-8811-47f3-b99a-0dc758dd2763"));
	}
	
}
