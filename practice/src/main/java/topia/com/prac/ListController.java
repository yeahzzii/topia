package topia.com.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import topia.com.prac.entity.UserInfoSkill;
import topia.com.prac.entity.userVO;
import topia.com.prac.personalHistory.serv.ListService;

@Controller
public class ListController {
	// http://localhost:8010/prac/userList.do
	/*
	@Autowired(required = false)
		private ListService service;

	
	@RequestMapping("userList.do")
	public String userList(userVO vo, UserInfoSkill skill, Model model) {
		
		model.addAttribute("listPage", service.userList(vo, skill) );
		return "WEB-INF\\views\\list.jsp";
	}
	 */
		
}
