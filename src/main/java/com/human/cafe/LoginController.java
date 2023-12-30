package com.human.cafe;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.human.service.IF_memberService;
import com.human.vo.MemberVO;

@RestController
public class LoginController {
	@Inject
	IF_memberService memberService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public String idchk(@RequestParam String userid, @RequestParam String pwd) throws Exception{// jsp에서 JSON.stringify 없어야 함.
		MemberVO m = memberService.selectOne(userid);
		System.out.println(passwordEncoder+"----------------");
		String securePw = passwordEncoder.encode(pwd);
		System.out.println("kkkk >  " + userid +"/" +pwd +"/"+securePw );
		if(m.getPass().equals(pwd)) {
			return "2";
		}
		return "0";
	}
//
/*	
	public int idchk(@RequestBody String userid) {
		System.out.println("kkkk >  " + userid  );
		if(userid.equals("111")) {
			return 2;
		}
		return 0;
	} 
*/		
	
// Map으로 받기
/*	
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	@ResponseBody
	public int idchk1(@RequestBody Map<String, Object> a) {   // jsp에서 JSON.stringify 해 줘야 함...
		String userid=(String)a.get("userid");
		System.out.println("kkkk >  " + userid +"/"  );
		if(userid.equals("111")) {
			return 2;
		}
		return 0;
	}*/
	
	//----------------------------------------
/*	
	@ResponseBody
	public int idCheck(@RequestParam("userid") String id) {
		
		System.out.println(id);
		return cnt;
		
	}*/


	//REST 동작 정의 ------------------------------
	// 삭제

		@DeleteMapping("/users/{id}")
		public int deleteUser(@PathVariable String id) {
			System.out.println(id+" delete   rest");
			return 1;
		}
		/*		
		// 수정
		@PutMapping("/users")
		public int updateUser(@RequestBody UserVO user) {
			return dao.updateUser(user);
		}
		
	*/	
		// 등록
		@PostMapping("/users")
		public int insertUser(@RequestBody MemberVO mvo) throws Exception{
			//System.out.println("rest insert");
			memberService.memberInsert(mvo);
			return 1;
		}
	/*			
		
		// 1명 조회
		@GetMapping("/users/{userid}")
		public UserVO user(@PathVariable String userid) {
			return dao.getUser(userid);
		}
	*/	
		
		// 목록조회
		@GetMapping("/users")
		public List<MemberVO> users() throws Exception{
			return memberService.getUsers();
		}
		

}
