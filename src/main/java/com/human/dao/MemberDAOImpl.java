package com.human.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.vo.MemberVO;

@Repository
public class MemberDAOImpl implements IF_memberDAO {
	private static String mapperQuery = "com.human.dao.IF_memberDAO"; // 매핑 인터페이스 경로설정
	@Inject
	private SqlSession sqlSession; // SqlSession 타입의 객체는 스프링 컨테이너에 있다.
									// 여기서 이 객체가 필요하다. 그런데 컨테이너에서 가져와야한다. 스프링은 DI개념

	@Override
	public MemberVO SelectOne(String id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuery + ".selectOne", id);
	}

	@Override
	public void insertOne(MemberVO mvo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuery+".insertOne", mvo);
	}

	@Override
	public List<MemberVO> getUsers() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuery+".selectAll");
	}

}
