package org.seung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seung.domain.BoardVO;
import org.seung.dto.PageDTO;

public interface BoardMapper extends CrudMapper<BoardVO, Integer>, ListMapper<BoardVO> {
	
	// ���ǿ� �´� �˻�� �Է��� �� ��Ϻ����ִ� �޼���
	public List<BoardVO> searchList(PageDTO dto);

	// �˻��� ����Ʈ�� ������ �˷��ִ� �޼���
	public int searchCount(PageDTO dto);
}
