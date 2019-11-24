package org.seung.service;

import java.util.List;

import org.seung.domain.BoardAttachVO;

public interface AttachService {
	
	public boolean insertAttach(BoardAttachVO vo);
	
	public int updateAttach(BoardAttachVO vo);
	
	public List<BoardAttachVO> getAttachList(Integer bno);
	
	public boolean deleteFile(String uuid);
}
