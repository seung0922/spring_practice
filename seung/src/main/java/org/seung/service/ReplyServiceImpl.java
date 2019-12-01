package org.seung.service;

import java.util.List;

import org.seung.domain.ReplyPageDTO;
import org.seung.domain.ReplyVO;
import org.seung.dto.PageDTO;
import org.seung.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {

		log.info("register.............." + vo);
		
		return mapper.insert(vo);
	}
	
	@Override
	public int registerReply(ReplyVO vo) {
		
		log.info("register reply.............." + vo);
		
		return mapper.insertReply(vo);
	}

	@Override
	public ReplyVO get(Integer rno) {

		log.info("get..........." + rno);
		
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {

		log.info("modify..........." + vo);
		
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer rno) {

		log.info("remove..........." + rno);
		
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(PageDTO pg, Integer bno) {

		log.info("get Reply List of a Board" + bno);
		
		return mapper.getListWithPaging(pg, bno);
	}

	@Override
	public ReplyPageDTO getListPage(PageDTO pg, Integer bno) {

		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(pg, bno));
	}

	@Override
	public List<ReplyVO> getList2(Integer bno) {
		
		return mapper.getListWithPaging2(bno);
	}


}
