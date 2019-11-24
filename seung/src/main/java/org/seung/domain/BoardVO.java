package org.seung.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {

	private Integer bno;
	private String title, content, writer;
	private Date regdate;
	private Date updatedate	;
	
	private List<BoardAttachVO> attachList;
	
	private String[] delFileName;
	
}
