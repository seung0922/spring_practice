package org.seung.mapper;

import java.util.List;

import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;

public interface BoardMapper {
	
	public int insert(BoardVO vo);
	
	public List<BoardVO> listPage(PageDTO dto);
	
	public int countPage(PageDTO dto);
	
}
