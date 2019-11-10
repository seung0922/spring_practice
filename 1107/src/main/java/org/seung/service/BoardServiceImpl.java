package org.seung.service;

import java.util.List;

import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;
import org.seung.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;

	@Override
	public boolean register(BoardVO vo) {
		log.info(vo);
		return mapper.insert(vo) == 1 ? true : false;
	}

	@Override
	public List<BoardVO> getList(PageDTO dto) {
		log.info(dto);
		return mapper.listPage(dto);
	}

	@Override
	public int getListCount(PageDTO dto) {
		log.info(dto);
		return mapper.countPage(dto);
	}

	@Override
	public BoardVO findByBno(Integer bno) {
		log.info(bno);
		return mapper.selectByBno(bno);
	}
	
	
}
