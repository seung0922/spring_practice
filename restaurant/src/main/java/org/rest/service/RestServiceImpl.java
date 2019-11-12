package org.rest.service;

import java.util.List;

import org.rest.domain.RestVO;
import org.rest.mapper.RestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class RestServiceImpl implements RestService {

	@Setter(onMethod_ = @Autowired)
	private RestMapper mapper;
	
	@Override
	public List<RestVO> getList() {
		log.info("list in service");
		return mapper.getList();
	}

}
