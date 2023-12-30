package com.human.cafe;

import java.security.Principal;
import java.util.Collection;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.service.IF_memberService;

@Controller
public class UserLogin {
	
	@Inject
	private IF_memberService memberService;
	
	@RequestMapping(value="/loginPage")
    public String page() throws Exception {
	 	System.out.println("loginPage Controller");
        return "/login";
    }

	@RequestMapping(value="/login_sucess", method=RequestMethod.GET)
	public String login(HttpSession session,Locale locale, Model model, Principal p) throws Exception{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(p.getName()+"asdfasfasf");
		String userid = "";//아이디
		String levels = "";//ROLE_ANONYMOUS
		Boolean enabled = false;
		Object principal = authentication.getPrincipal();
		if (principal instanceof UserDetails) {
			//인증이 처리되는 로직(아이디,암호를 스프링시큐리티 던져주고 인증은 스프링에서 알아서 해줌.)
			enabled = ((UserDetails)principal).isEnabled();
		}
		userid =((UserDetails)principal).getUsername();
	//	System.out.println(userid+"님입니다");
	//	session.setAttribute("session_userid", userid);
		
		if (enabled) { //인증처리가 완료된 사용자의 권한체크(아래)   https://zgundam.tistory.com/49
			Collection<? extends GrantedAuthority>  authorities = authentication.getAuthorities();
			if(authorities.stream().filter(o -> o.getAuthority().equals("ROLE_ANONYMOUS")).findAny().isPresent())
			{levels = "ROLE_ANONYMOUS";}
			if(authorities.stream().filter(o -> o.getAuthority().equals("ROLE_USER,")).findAny().isPresent())
			{levels = "ROLE_USER,";}
			if(authorities.stream().filter(o -> o.getAuthority().equals("ROLE_ADMIN")).findAny().isPresent())
			{levels = "ROLE_ADMIN";}
			userid =((UserDetails)principal).getUsername();
			//로그인 세션 저장
			session.setAttribute("session_enabled", enabled);//인증확인
			session.setAttribute("session_userid", userid);//사용자아이디
			System.out.println(userid+" 세션등록");
			session.setAttribute("session_levels", levels);//사용자권한
			//=========== 상단은 스프링시큐리티에서 기본제공하는 세션 변수처리
			//=========== 하단은 우리가 추가한는 세션 변수처리
			//회원이름 구하기 추가
		//	MemberVO memberVO = memberService.viewMember(userid);
		//	session.setAttribute("session_username", memberVO.getUser_name());//사용자명
			model.addAttribute("principal",principal);
        }
		return "redirect:/";		
	}
	
	/*
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session,
			            @RequestParam("id") String id,
			            @RequestParam("pass") String pass) throws Exception{
		// 로그인 절차
		// 1. 파라미터 받는다  2. 쿼리 실행 후 결과값에 따라 판다..  서비스 단이 필요 
		// 현재는 테스트용으로 하겠습니다.	
		MemberVO m = memberService.selectOne(id);
		if(m != null) {  // 쿼리 실행 후 아이와 패스워드가 정상적인 경우 리턴 받는 것으로 수정..
			//로그인 성공인경우  세션처리
			if(session.getAttribute("login") != null) {
				session.removeAttribute("login");  // 일종의 초기화. 한번더 청소하고 가겠다.
			}
			session.setAttribute("login", id); // 세션처리
			session.setAttribute("grade", "vip"); // 처리하고 싶은 변수를 선택하여 등록, 객체도 가능		
		}else {
			//로그인 실패인 경우
			
		}
		//   <---- 여기까지가 테스트용 나중에 디비연동 시켜야 한다..
		System.out.println("로그인 공사 중...");
		return "home";		
	}	
	 */	
	
	@RequestMapping(value="/login_fail", method=RequestMethod.GET)
	public String login_fail(HttpSession session,Locale locale, HttpServletRequest reques) throws Exception{
		//HttpSession session = request.getSession(false);
        if(session==null) return null;
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        System.out.println("세션 클리어 성공");
		return "redirect:/loginPage";		
	}
	
	// 현재 로그아웃은 security 에서 처리 하는 것..
	@RequestMapping(value="/logout_After", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); //세션을 무력화..
		System.out.println("로그아웃처리 --- 디버깅");
		return "home";
	}
}
