package org.seung.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/security-context.xml")
@Log4j
public class GgupdegiTests {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void test1() {
		
		String text = "abcde";
		
		String en1 = encoder.encode(text);
		
		log.info(en1);
		
		String en2 = encoder.encode(text);
		
		log.info(en2);
		
	}
	
	@Test
	public void test2() {
		
		boolean result = encoder.matches("abcde", "$2a$10$F6x9q.GSdteZmZtHNzgJruKQ4qHcrlajEowLBO5d.3l/lSZfL5c76");
		
		log.info(result);
		
	}
	
}
