package org.seung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;

public interface BoardMapper extends CrudMapper<BoardVO, Integer>, ListMapper<BoardVO> {
	
	// 조건에 맞는 검색어를 입력한 뒤 목록보여주는 메서드
	public List<BoardVO> searchList(PageDTO dto);

	// 검색한 리스트의 개수를 알려주는 메서드
	public int searchCount(PageDTO dto);
}
