package org.seung.mapper;

import org.apache.ibatis.annotations.Insert;
import org.seung.domain.AuthVO;
import org.seung.domain.MemberVO;

public interface MemberMapper {
	@Insert("insert into tbl_member (userid, userpw, username) values (#{userid}, #{userpw}, #{username})")
	public boolean insertMember(MemberVO vo);
	
	@Insert("insert into tbl_auth (userid, auth) values (#{userid}, #{auth})") 
	public boolean insertAuth(AuthVO vo); 
	
	public MemberVO getMember(String memid);
}
