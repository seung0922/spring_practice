package org.seung.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seung.domain.BoardVO;
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
	public void searchTest() {
		
		log.info("search");
		
		// Ű����� �˻��� ��� ������ ����
		List<BoardVO> list = boardMapper.searchList(
				0,
				10,
				"����",
				new String[] {"T", "C"});
		
		log.info(list);
		
		// ��� ����Ʈ �ݺ������� ����
		list.forEach(vo ->{
			log.info(vo);
		});
	}

	@Test
	public void insertTest() {

		log.info("insert");
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("�����λ�� ����");
		vo.setContent("���̳� ����");
		vo.setWriter("��¿�");
		
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
