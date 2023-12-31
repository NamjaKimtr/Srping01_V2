package com.human.cafe;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.service.IF_boardService;
import com.human.util.FileDataUtil;
import com.human.vo.BoardVO;
import com.human.vo.PageVO;

import lombok.RequiredArgsConstructor;

@Controller   
@RequiredArgsConstructor  // lombok 어노테이션은 NotNull이거나 final이 붙은 변수들에 대해 생성자를 만들어주는 기능을 제공하고 있다.
public class BbsController {
	//@Inject
	private final IF_boardService bsrv;
	//@Inject
	private final FileDataUtil fileDataUtil;
	
	@RequestMapping(value = "/bbswrAction", method = RequestMethod.POST)
	public String WrAction(Locale locale, Model model, BoardVO bvo, MultipartFile[] file) throws Exception{
		System.out.println(bvo.toString());
		// 객체로 받을 때는 파라미터이름과 객체의  변수의 이름이 일치하고 getter, setter가 있어야 한다. > 자동매핑
		//System.out.println(bvo.getName() +" -- 디버깅용도");
		//System.out.println(file.getOriginalFilename() +"--- 첨부파일 디버깅");
		//filedatautil 객체의 fileupload메서드를 호출 .. 매개변수로  file을 넘긴다.. <지정한 폴더로 첨부파일 복사>
		String[] fileNames = fileDataUtil.fileUpload(file);
		// 넘겨받은 파일명을  boardVO files변수에 저장한다.
		bvo.setFiles(fileNames);
		// 디비작업..합니다.
		bsrv.insertOne(bvo);	
		
		return "redirect:/bbsList";  // 수정예정
	}
	@RequestMapping(value = "/bbsList", method = RequestMethod.GET)
	public String bbsList(Locale locale, Model model, @ModelAttribute("pageVO") PageVO pageVO) throws Exception{
		// 객체로 받을 때는 파라미터이름과 객체의  변수의 이름이 일치하고 getter, setter가 있어야 한다. > 자동매핑
		//System.out.println(bvo.getName() +" -- 디버깅용도");
		//bsrv.insertOne(bvo);		
		// page 계산하기 위해서는 첫번째 페이지정보(클라이언트가 넘겨줍니다), 두번째는 전체페이지수, 세번째는 페이지당그리고 페이지그룹당 수 
		if(pageVO.getPage() == null) {  // 클라이언트가 페이지 정보를 넘겨 주지 않은다면 기본값 1로 셋팅..
			pageVO.setPage(1);
		}
		System.out.println("현재 페이지 정보 : "+pageVO.getPage());
	
		int totalpageCnt = bsrv.countBoard();   // select count(*) from board;
		System.out.println(totalpageCnt +"건 등록됨.");
		pageVO.setTotalCount(totalpageCnt);  
		
		System.out.println( pageVO.getStartNo() +"/"+pageVO.getEndNo());
		
		List<BoardVO> list = bsrv.selectAll(pageVO);  // 페이징 쿼리에 매핑.. 매개변수필요..
	
		System.out.println(list.size() +" 건 가져옴. 디버깅 용");
		model.addAttribute("bList",list);
		model.addAttribute("pageVO",pageVO);  // 페이지 객체를 view에게 전달 
		return "bbs/bbsList";  // 수정예정
	}
	@RequestMapping(value = "/bbswrForm", method = RequestMethod.GET)
	public String WrAction1(Locale locale, Model model) {
		return "bbs/wrForm";
	}
	@RequestMapping(value = "/bbsView", method = RequestMethod.GET)
	public String BBsView(Locale locale, Model model, @RequestParam("vno") String vno) throws Exception{
		// DB작업
		bsrv.updatecnt(vno);
		BoardVO tempvo = bsrv.selectOne(vno);
		
		model.addAttribute("boardVO", tempvo);
		List<String> attachList = bsrv.selectAttach(vno);
		model.addAttribute("attachList", attachList);		
		return "bbs/bbsview";
	}
	@RequestMapping(value = "/bbsDel", method = RequestMethod.GET)
	public String BBsDel(Locale locale, Model model, @RequestParam("vno") String vno) throws Exception{
		bsrv.boardDel(vno);
		return "redirect:bbsList";
	}

	@RequestMapping(value = "/bbsMod", method = RequestMethod.GET)
	public String BBsMod(Locale locale, Model model, @RequestParam("vno") String vno) throws Exception{
		BoardVO tempvo = bsrv.selectOne(vno);
		model.addAttribute("boardVO", tempvo);
		return "bbs/bbsmod";
	}
	@RequestMapping(value = "/bbsModAction", method = RequestMethod.POST)
	public String bbsModAction(Locale locale, Model model, BoardVO bvo, MultipartFile[] file, RedirectAttributes rdat) throws Exception{
		bsrv.udpateBoard(bvo);	
		rdat.addAttribute("vno", bvo.getNum());
		return "redirect:/bbsView";  // 수정예정
	}

}
