package org.seung.dto;

import lombok.Data;

@Data
public class PageMaker {

	private int start, end;
	private int total;
	private boolean next, prev;
	private PageDTO dto;
	
	
	public PageMaker(int total, PageDTO dto) {
		this.total = total;
		this.dto = dto;
	
		int tempEnd = (int)(Math.ceil(dto.getPage()/10.0)*10);
		
		start = tempEnd - 9;
		
		prev = start != 1 ? true : false;
		
		int realEnd = (int)(Math.ceil(total/(double)dto.getAmount()));
		
		this.end = Math.min(realEnd, tempEnd);
		
		this.next = this.end * dto.getAmount() < total;
	}
	
	
}
