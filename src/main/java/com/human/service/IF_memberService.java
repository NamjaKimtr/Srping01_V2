package com.human.service;

import java.util.List;

import com.human.vo.MemberVO;

public interface IF_memberService {
	
	public MemberVO selectOne(String id) throws Exception;
	public void memberInsert(MemberVO mvo) throws Exception;
	public List<MemberVO> getUsers() throws Exception;
}
