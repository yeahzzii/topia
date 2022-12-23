package topia.com.prac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import topia.com.prac.entity.Board;
import topia.com.prac.entity.Criteria;
import topia.com.prac.entity.Member;
import topia.com.prac.entity.PageMake;
import topia.com.prac.personalHistory.serv.MemberServImpl;

@Controller
public class MemberController {
	@Autowired(required = false)
	MemberServImpl service;

	
	// 회원가입 정보 입력 화면 
	// http://localhost:8010/prac/register
	@RequestMapping(value = "/register")
	public String register() {
		return "register";
	}

	// 회원가입 정보 입력 화면 - insert action
	@RequestMapping(value = "/insertMember")
	public String insertMember(Member ins, Model model) {
		service.insertMember(ins);
		model.addAttribute("isInsert", "Y");
		System.out.println("회원 가입 완료");
		return "login";
	}
	
	// 아이디 중복 확인 ajax 처리 pageJsonReport
	// http://localhost:8010/prac/hasId?userId=abcd1234
		@RequestMapping(value = "/hasId", method = RequestMethod.GET)
		public String hasId(@RequestParam("userId") String userId, Model model) {
			// 해당 회원이 중복일 때 true, 사용 가능할 때 false
			model.addAttribute("hasId", service.hasId(userId) == 0 ? false : true);
			return "pageJsonReport";
		}
		
	// 로그인 페이지
		@RequestMapping(value = "/login")
		public String login() {
			return "login";
		}
		
	// 로그인
		
		@RequestMapping(value = "/loginaction")
		public String loginaction(@ModelAttribute("member") Member m , Model model,
			HttpServletRequest request) {
			if(m.getUserId() != null && m.getUserPassword() != null) {
				Member member = service.getMember(m);
				HttpSession session = request.getSession();
				if(member != null && !member.getUserId().equals("") && !member.getUserPassword().equals("")) {
					System.out.println(member.getUserName());
					// DB에 데이터가 있을 때 session 처리
					session.setAttribute("member", member);
					int time = 1800;
					session.setMaxInactiveInterval(time);
					model.addAttribute("time01", time);
					model.addAttribute("isLogin", "Y");
					return "login";
				}else {
					model.addAttribute("msg", "아이디 혹은 비밀번호가 일치하지 않습니다.");
					model.addAttribute("isLogin", "N");
					return "login";
				}
			}
			return "login ";
		}
		
		// 로그아웃
		@RequestMapping(value = "/logout")
		public String logout(@ModelAttribute("member") Member m,
				HttpServletRequest request, Model d){
			
			// 로그아웃 시 세션 제거
			request.getSession().removeAttribute("member");
			return "login";
		}
		
		
		// http://localhost:8010/prac/memberList
		@RequestMapping(value = "/memberList")
		private String memberList(Member member, Model model) {
			
			model.addAttribute("member", service.boardList(member));
			
		
			
			return "memberList";
		}
		
		
}
