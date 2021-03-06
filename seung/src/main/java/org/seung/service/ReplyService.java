package org.seung.service;

import java.util.List;

import org.seung.domain.ReplyPageDTO;
import org.seung.domain.ReplyVO;
import org.seung.dto.PageDTO;

public interface ReplyService {

	public int register(ReplyVO vo);
	
	public int registerReply(ReplyVO vo);
	
	public ReplyVO get(Integer rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(Integer rno);
	
	public List<ReplyVO> getList(PageDTO pg, Integer bno);	// 댓글
	
	public ReplyPageDTO getListPage(PageDTO pg, Integer bno);
	
	public List<ReplyVO> getList2(Integer bno); // 대댓글
}
