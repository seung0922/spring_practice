package org.seung.mapper;

import java.util.List;

import org.seung.domain.BoardAttachVO;

public interface AttachMapper {

	public int insertAttach(BoardAttachVO vo);
	
	public int updateAttach(BoardAttachVO vo);
	
	public List<BoardAttachVO> selectAttachList(Integer bno);
	
	public int deleteFile(String uuid);
}
