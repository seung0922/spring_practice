package org.seung.dto;

import lombok.Data;

@Data
public class PageDTO {

	private int page = 1;
	private int amount = 10;
	private String keyword;
	private String type;
	private int bno;

	public int getSkip() {
		return (page -1) * amount;
	}
	
	public String[] getTypes() {
		// 들어온 type값이 없거나 공백이면 null반환
		if(type == null || type.trim().length() == 0) {
			return null;
		}
		
		// 한글자씩 분리해서 배열로 리턴
		return type.split("");
	}

}
