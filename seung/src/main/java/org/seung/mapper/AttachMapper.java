package org.seung.mapper;

import java.util.List;

import org.seung.domain.BoardAttachVO;

public interface AttachMapper {

	public int insertAttach(BoardAttachVO vo);
	
	public List<BoardAttachVO> selectAttachList(Integer bno);
	
	public String selectImg(String fname, Integer bno);
}
