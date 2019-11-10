package org.seung.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageMaker {
	
	private int start, end;
	private boolean prev, next;
	private int total;
	private PageDTO dto;
	
	public PageMaker(PageDTO dto, int total) {
		this.dto = dto;
		this.total = total;
		
		int tempEnd = (int)(Math.ceil(dto.getPage()/10.0)) * dto.getAmount();
		this.start = tempEnd - (dto.getAmount()-1);
		
		this.prev = this.start != 1;
		
		int realEnd =
				(int)(Math.ceil(total/(double)dto.getAmount()));
		
		this.end = tempEnd > realEnd ? realEnd : tempEnd;
		
		this.next = total > this.end * dto.getAmount();
		
	}

}
