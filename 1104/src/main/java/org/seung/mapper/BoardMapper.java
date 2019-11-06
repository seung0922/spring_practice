package org.seung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seung.domain.BoardVO;

public interface BoardMapper extends CrudMapper<BoardVO, Integer>, ListMapper<BoardVO> {
	
	// ���ǿ� �´� �˻�� �Է��� �� ��Ϻ����ִ� �޼���
	public List<BoardVO> searchList(
			@Param("skip") int skip,
			@Param("amount") int amount,
			@Param("keyword") String keyword,
			@Param("type") String[] type
			);

	// �˻��� ����Ʈ�� ������ �˷��ִ� �޼���
	public int searchCount(
			@Param("keyword") String keyword,
			@Param("type") String[] type
			);
}
