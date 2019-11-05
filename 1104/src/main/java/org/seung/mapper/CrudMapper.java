package org.seung.mapper;

public interface CrudMapper<E, K> {
	
    public int insert(E vo);
    public int update(E vo);
    public E select(K key);
    public int delete(K key);

}
