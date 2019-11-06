package org.seung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ListMapper<E> {

	public List<E> selectList(@Param("skip") int skip);
	
}
