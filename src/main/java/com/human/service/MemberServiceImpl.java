package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.dao.IF_memberDAO;
import com.human.vo.MemberVO;
@Service
public class MemberServiceImpl implements IF_memberService{
	@Inject
	private IF_memberDAO memberdao;
	@Override
	public MemberVO selectOne(String id) throws Exception {
		// TODO Auto-generated method stub
		return memberdao.SelectOne(id);
	}
	@Override
	public void memberInsert(MemberVO mvo) throws Exception {
		// TODO Auto-generated method stub
		memberdao.insertOne(mvo);
	}
	@Override
	public List<MemberVO> getUsers() throws Exception {
		// TODO Auto-generated method stub
		return memberdao.getUsers();
	}

}
