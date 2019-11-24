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
	@Transactional
	public boolean update(BoardVO vo) {
		
		log.info("update...................");
		log.info(vo);
		
		// 1. 추가된 파일이 없고, 삭제할 파일 없을 때
		if ( (vo.getAttachList() == null || vo.getAttachList().size() <= 0) 
				&& (vo.getDelFileName() == null || vo.getDelFileName().length <= 0)) { 
			// 내용만 변경해줌
			return mapper.update(vo);
		}
		
		// 2. 추가된 파일 없는데, 삭제할 파일은 있을 때
		if (vo.getAttachList() == null || vo.getAttachList().size() <= 0) { 
			// 내용 변경해주고
			boolean result = mapper.update(vo);
			
			// 파일 삭제해줌
			for(int i=0; i<vo.getDelFileName().length; i++) {
				
				log.info("uuid : " + vo.getDelFileName()[i]);
				
				log.info(attachMapper.deleteFile(vo.getDelFileName()[i]));
			}
			
			return result;
		}
		
		// 3. 추가된 파일 있고, 삭제할 파일 없을 때
		if (vo.getDelFileName() == null || vo.getDelFileName().length <= 0) {
			// 내용 업데이트 하고 
			boolean result = mapper.update(vo);
			
			// 파일 추가하고
			vo.getAttachList().forEach(attach -> {
				
				attach.setBno(vo.getBno());
				attachMapper.updateAttach(attach);

			});
			
			return result;
		}
		
		// 4. 추가된 파일 있고, 삭제할 파일 있을 때
		// 내용 업데이트 하고 
		boolean result = mapper.update(vo);
		
		// 파일 추가하고
		vo.getAttachList().forEach(attach -> {
			
			attach.setBno(vo.getBno());
			attachMapper.updateAttach(attach);

		});
		
		// 파일 삭제하고
		for(int i=0; i<vo.getDelFileName().length; i++) {
			
			log.info("uuid : " + vo.getDelFileName()[i]);
			
			log.info(attachMapper.deleteFile(vo.getDelFileName()[i]));
		}
		
		return result;
	}

	@Override
	public int getCount(PageDTO dto) {

		log.info("get Count......................");

		return mapper.getCount(dto);
	}

	

}
