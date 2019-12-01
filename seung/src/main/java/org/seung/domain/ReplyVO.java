package org.seung.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private Integer rno;
	private Integer bno;
	private Integer byrno;
	private Integer depth;
	
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}
