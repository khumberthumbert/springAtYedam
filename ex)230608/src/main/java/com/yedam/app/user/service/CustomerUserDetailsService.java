package com.yedam.app.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yedam.app.user.mapper.UserMapper;

//어노테이션하고 주소 적는 방법 못 읽어 들어서 그냥 빈 등록해줬음.
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserVO userVO = userMapper.getUser(username);
		
		// 해당 사용자 존재유무 확인
//		if(userVO == null) {
//			throw new UsernameNotFoundException("no user");
//		}
		
		// 비밀번호 확인
		
		//권한 지정
		//권한 지정 별도로 처리하는 이유 -> 권한이 여러개면 쿼리문 하나로 처리하기 불가능
//		List<GrantedAuthority> auth = new ArrayList<>(); 
//		auth.add(new SimpleGrantedAuthority(userVO.getRole()));
//		
//		return new UserVO(username, userVO.getPassword(), auth);
		
		return userVO;
	}

}
