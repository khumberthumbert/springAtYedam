package com.yedam.app.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails {
	// private MemberVO member; 이 형태를 많이 쓴다. 우리가 다루는 vo를 따로 만들어서. 필드로 집어 넣는 방식.
	// 이그노어 대상을 명시해줘야한다.
	private String id;
	private String pwd;
	private String role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		//getAuthorities()가 문제 된다. jackson 데이터로 보낼 때. 리턴타입 Collection. 이걸 json이 커버를 못함.
		//어떻게 해결해야 할까? -> 우리가 다루는 vo를 따로 만들어서 필드로 집어 넣는 방식을 많이 쓴다.
		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(this.role));
		return auth;
	}

	@Override
	public String getPassword() {
		return pwd;
	}

	@Override
	public String getUsername() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
