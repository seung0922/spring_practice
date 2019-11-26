package org.seung.dto;

import lombok.Data;

@Data
public class PageDTO {

	private Integer bno;
	private int page = 1;
	private int amount = 10;
	private String type, keyword;
	

	public PageDTO(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
	
	public int getSkip() {
		return (page - 1) * amount;
	}
	
	public String[] getTypes() {
		if(type == null || type.trim().length()==0) {
			return null;
		}
		
		return type.split("");
	}

	public PageDTO() {
	}

	
}
