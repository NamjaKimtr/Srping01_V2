package com.human.dao;

import java.util.List;

import com.human.vo.MemberVO;

public interface IF_memberDAO {
	
	public MemberVO SelectOne(String id) throws Exception;
	public void insertOne(MemberVO mvo) throws Exception;
	public List<MemberVO> getUsers() throws Exception;

}
