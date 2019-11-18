package org.seung.controller;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seung.domain.AuthVO;
import org.seung.domain.MemberVO;
import org.seung.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/security-context.xml"
	,"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@Log4j
public class GgupdegiTests {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private MemberMapper memberMapper;

	@Test
	public void testGetMember(){
	  MemberVO vo = memberMapper.getMember("admin95");
	  log.info(vo);
	}

	
	@Test
	public void testInsertadminRole() {
		IntStream.range(90,101).forEach(i->{
			AuthVO vo = new AuthVO();
				vo.setUserid("admin"+i);
				vo.setAuth("ROLE_ADMIN");
			memberMapper.insertAuth(vo);
		});
	}
	
	@Test
	public void testInsertMemberRole() {
		IntStream.range(1,101).forEach(i->{
			MemberVO vo = new MemberVO();
			if(i<90) {
				vo.setUserid("user"+i);
				vo.setUserpw(encoder.encode("user"+i));
				vo.setUsername("사용자"+i);
			}else {
				vo.setUserid("admin"+i);
				vo.setUserpw(encoder.encode("admin"+i));
				vo.setUsername("관리자"+i);
			}
			memberMapper.insertMember(vo);
		});
	}

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
