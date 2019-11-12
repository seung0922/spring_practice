package org.rest.domain;

import lombok.Data;

@Data
public class RestVO {
	
	Integer rno;
	String rname;
	double lat, lng;
	String category;
	double distance;
	
}
