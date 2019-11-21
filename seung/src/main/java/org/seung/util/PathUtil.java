package org.seung.util;

public class PathUtil {
	
	public String sTh(String str) {
		
		return str.replace("\\", "-");
	}
	
	public String hTs(String str) {
		
		return str.replace("-", "\\");
	}

}
