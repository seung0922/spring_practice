package org.seung.mapper;

import java.util.List;

import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;

public interface BoardMapper {

	public int insert(BoardVO vo);
	
	public List<BoardVO> getList(PageDTO dto);
	
	public BoardVO selectByBno(Integer bno);
	
	public boolean delete(Integer bno);
	
	public boolean update(BoardVO vo);
	
	public int getCount(PageDTO dto);
	
	public List<BoardVO> searchList(PageDTO dto);
	
}
