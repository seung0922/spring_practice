package org.seung.security;

import org.seung.domain.MemberVO;
import org.seung.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info(memberMapper);
		
		log.info("custom user service......");
		log.info("custom user service......");
		log.info("custom user service......");
		log.info("custom user service......");
		
		MemberVO member = memberMapper.getMember(username);
		
		if(member == null) {
		    throw new UsernameNotFoundException("낫푸~~~");
		  }
		
		return new CustomUser(member);
		/*
		 * String[] arr = {"ROLE_MEMBER", "ROLE_ADMIN"}; List<SimpleGrantedAuthority>
		 * authList = null;
		 * 
		 * authList = Arrays.stream(arr) .map(str -> new SimpleGrantedAuthority(str))
		 * .collect(Collectors.toList());
		 * 
		 * CustomUser user = new CustomUser(username,
		 * "$2a$10$WjKqScBQv5gYw4h9hQ8c6eU6E49PvznmCc9nkxYM/ezEGAGHxvCK.", authList);
		 * return user;
		 */
	}
}
