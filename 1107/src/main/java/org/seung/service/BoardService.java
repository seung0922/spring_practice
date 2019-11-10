package org.seung.service;

import java.util.List;

import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;

public interface BoardService {
	
	public boolean register(BoardVO vo);
	
	public List<BoardVO> getList(PageDTO dto);
	
	public int getListCount(PageDTO dto);
	
	public BoardVO findByBno(Integer bno);
}
