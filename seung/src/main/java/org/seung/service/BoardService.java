package org.seung.service;

import java.util.List;

import org.seung.domain.BoardAttachVO;
import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;

public interface BoardService {

	public boolean register(BoardVO vo);
	
	public List<BoardVO> getList(PageDTO dto);
	
	public BoardVO selectByBno(Integer bno);
	
	public boolean delete(Integer bno);

	public boolean update(BoardVO vo);
	
	public int getCount(PageDTO dto);
	
	public List<BoardAttachVO> getAttachList(Integer bno);
}
