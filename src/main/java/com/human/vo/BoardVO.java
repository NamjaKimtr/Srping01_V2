package com.human.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	
	public int num;
	public String name;
	public String email;
	public String title;
	public String content;
	public String pass;
	public int cnt;
	public String indate;
	
	private String[] files;  // 클라이언트로 부터 받은 파일을 바로 저장하는 것이 아니라. 컨트롤러가 작업해서 셋팅할 겁니다.
	
	

}
