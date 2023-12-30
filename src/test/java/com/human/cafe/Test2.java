package com.human.cafe;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;



//@ContextConfiguration(classes=ServletContext.class) 자바로 작성했을 경우
//@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class Test2 {

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Inject
	private SqlSession sqlSession;
	
	@Autowired
	private ApplicationContext context;
	
	@Test
	public void sqltest() {
		assertNotNull(sqlSession);
	}
	
	@Test
	public void uploadPath() {
		assertNotNull(uploadPath);
		System.out.println(uploadPath);
	}
	
	@Test
	public void test() {
		DriverManagerDataSource ds = (DriverManagerDataSource)context.getBean("dataSource");
		try {
			ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(ds);
	//	assertNotNull(uploadPath);
	//	System.out.println(uploadPath);
	}

}
