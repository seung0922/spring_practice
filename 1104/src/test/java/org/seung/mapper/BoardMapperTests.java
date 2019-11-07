package org.seung.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = { @Autowired })
	private BoardMapper boardMapper;
	
	@Test
	public void testSearchList() {
		// mybatis는 메서드가 우선이라 set, get 우선순위
		log.info("search");
		
		PageDTO dto = new PageDTO();
		dto.setPage(1);
		dto.setAmount(10);
		dto.setKeyword("5");
		dto.setType("TW");
		
		// 키워드로 검색한 결과 변수에 담음
		List<BoardVO> list = boardMapper.searchList(dto);
		
		log.info(list);
		
		// 결과 리스트 반복문으로 찍음
		list.forEach(vo ->{
			log.info(vo);
		});
	}

	@Test
	public void insertTest() {

		log.info("insert");
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("가입인사는 개뿔");
		vo.setContent("잠이나 자자");
		vo.setWriter("김승원");
		
		log.info(boardMapper.insert(vo));

	}

	@Test
	public void selectTest() {

		log.info(boardMapper.selectList(10));

	}

	@Test
	public void test1() {

		log.info(boardMapper);

	}

}
