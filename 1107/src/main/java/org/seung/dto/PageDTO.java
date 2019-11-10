package org.seung.dto;

import lombok.Data;

@Data
public class PageDTO {

	private int page = 1;
	private int amount = 10;
	private String keyword;
	private String type;

	public int getSkip() {
		return (page -1) * amount;
	}
	
	public String[] getTypes() {
		// ���� type���� ���ų� �����̸� null��ȯ
		if(type == null || type.trim().length() == 0) {
			return null;
		}
		// �ѱ��ھ� �и��ؼ� �迭�� ����
		return type.split("");
	}

}
