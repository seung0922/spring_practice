package org.seung.dto;

import java.util.Arrays;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class PageDTO {

	private int page;
	private int amount;
	private String keyword;
	private String type;
	
	// ������ �⺻��
	public PageDTO() {
		this.page = 1;
		this.amount = 10;
	}
	
	// mybatis�� getter �� setter�� ����
	public int getSkip() {
		
		log.info("getSkip()....");
		return (this.page - 1) * this.amount;
		
	}
	
	public String[] getTypes() {
		
		log.info("getTypes....");
		
		String[] arr = this.type.split("");
		
		return arr;
	}
	
}
