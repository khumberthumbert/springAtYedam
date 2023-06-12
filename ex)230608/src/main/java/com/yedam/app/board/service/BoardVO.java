package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//import java.util.Date;
//이렇게 쓰고 싶다면 원하는 타입 핸들러 적어줘야한다.

import lombok.Data;


@Data
public class BoardVO {
	
	private int bno;
	private String title;
	private String contents;
	private String writer;
	
	//Date 타입은 다루기 까다롭다. 지역별로 기술별로 사용방법이 다르다. 세팅 신중하게.
	//우리는 인풋 태그를 통해 값을 받아 올 테니까 그것을 염두해야함.
	//DateTimeFormat 넘겨주는 데이터의 형식. 
	//받을 때는 별도의 작업을 해줘야함. 간단하게 하는 방법 ->
	@DateTimeFormat(pattern="yyyy-MM--dd")
	private Date regdate;
	@DateTimeFormat(pattern="yyyy-MM--dd")
	private Date updatedate;
	//java.util.Date가 받아들이는 타입이 있다. 얘들은 yyyy/MM/dd 만 받아들인다.
	//그래서 이 포맷으로 입력 해줘야한다.
	//input타입 날짜 포맷이 뭘까? -> 하이픈이다. yyyy-MM-dd
	//이렇게 하면 미스매치 생긴다. spring에서 제공하는 어노테이션이 있다. @DateTimeFormat
	
	private String image;
	

}
