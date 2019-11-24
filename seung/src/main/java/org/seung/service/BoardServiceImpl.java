package org.seung.service;

import java.util.List;

import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;
import org.seung.mapper.AttachMapper;
import org.seung.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Autowired
	private AttachMapper attachMapper;
	
	@Override
	@Transactional
	public boolean register(BoardVO vo) {

		log.info("register..................................");
		
		log.info(vo);

		if (vo.getAttachList() == null || vo.getAttachList().size() <= 0) {

			return mapper.insert(vo) == 1 ? true : false;

		}

		boolean result = mapper.insert(vo) == 1 ? true : false;
		
		vo.getAttachList().forEach(attach -> {
			
			attachMapper.insertAttach(attach);

		});
		
		return result;
	}

	@Override
	public List<BoardVO> getList(PageDTO dto) {

		log.info("get list.............");

		return mapper.getList(dto);
	}

	@Override
	public BoardVO selectByBno(Integer bno) {

		log.info("get read bno.....................");

		return mapper.selectByBno(bno);

	}

	@Override
	public boolean delete(Integer bno) {

		log.info("delete 궁쓰......................");

		return mapper.delete(bno);
	}

	@Override
	public boolean update(BoardVO vo) {
		
		log.info("update...................");
		
		log.info(vo.getDelFileName());

		// 추가된 파일이 없고, 삭제된 파일이 없을 때
		if ( (vo.getAttachList() == null || vo.getAttachList().size() <= 0) 
				&& (vo.getDelFileName() == null || vo.getDelFileName().length == 0) ) { 

			return mapper.update(vo);

		}

		// 내용 업데이트 하고 
		boolean result = mapper.update(vo);
		
		// 파일 추가하고
		vo.getAttachList().forEach(attach -> {
			
			attachMapper.insertAttach(attach);

		});
		
		// 파일 삭제하고
		for(int i=0; i<vo.getDelFileName().length; i++) {
			
			int idx = vo.getDelFileName()[i].indexOf("_");
			String uuid = vo.getDelFileName()[i].substring(0, idx);
			
			log.info("uuid : " + uuid);
			
			log.info(attachMapper.deleteFile(uuid));
		}
		
		return result;
	}

	@Override
	public int getCount(PageDTO dto) {

		log.info("get Count......................");

		return mapper.getCount(dto);
	}

	

}
