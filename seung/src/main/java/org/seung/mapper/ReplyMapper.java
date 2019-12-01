package org.seung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seung.domain.ReplyVO;
import org.seung.dto.PageDTO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);
	
	public int insertReply(ReplyVO vo);
	
	public ReplyVO read(Integer rno);
	
	public int delete(Integer rno);
	
	public int update(ReplyVO reply);
	
	public List<ReplyVO> getListWithPaging(
			@Param("pg") PageDTO pg,
			@Param("bno") Integer bno
			);
	
	public List<ReplyVO> getListWithPaging2(@Param("bno") Integer bno);
	
	public int getCountByBno(Integer bno);
	
	public int deleteByBno(Integer bno);
}
