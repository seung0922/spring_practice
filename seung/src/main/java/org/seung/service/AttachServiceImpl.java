package org.seung.service;

import java.util.List;

import org.seung.domain.BoardAttachVO;
import org.seung.mapper.AttachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AttachServiceImpl implements AttachService {
	@Autowired
	private AttachMapper attachMapper;
	@Override
	public boolean insertAttach(BoardAttachVO vo) {
		log.info("insert attach...................");
		return attachMapper.insertAttach(vo) == 1 ? true : false;
	}

	@Override
	public List<BoardAttachVO> getAttachList(Integer bno) {
		
		log.info("get attach list..............");
		
		return attachMapper.selectAttachList(bno);
	}

	@Override
	public boolean deleteFile(String uuid) {
		log.info("delete file...................");
		return attachMapper.deleteFile(uuid) == 1 ? true : false;
	}

}
