package topia.com.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import topia.com.prac.entity.Board;
import topia.com.prac.entity.Criteria;
import topia.com.prac.entity.PageMake;
import topia.com.prac.personalHistory.serv.BoardServImpl;

@Controller
public class BoardController {
	@Autowired(required = false)
	BoardServImpl service;
	
	// http://localhost:8010/prac/boardList
	@RequestMapping(value = "/boardList")
	private String boardList(Board board, Model model, Criteria cri) {
		
		model.addAttribute("board", service.getListPaging(cri));
		
		int total = service.getTotal(cri);
        
        PageMake pageMake = new PageMake(cri, total);
        
        model.addAttribute("pageMake", pageMake);
		
		return "boardList";
	}
	
	@RequestMapping(value = "/boardInsertForm")
	public String boardInsertForm(Board board){
		return "boardInsert";
	}
	
	@RequestMapping(value = "/boardInsert" ,method = RequestMethod.POST)
	public String boardInsert(Board ins, Model model){
		service.boardInsert(ins);                                   
		model.addAttribute("isInsert","Y");
		return "boardInsert";
	}
	
	@RequestMapping(value = "/boardDetail")
	public String boardDetail(@RequestParam("boardNum") int boardNum, Model model){
		model.addAttribute("board",service.boardDetail(boardNum));
		return "boardDetail";
	}
	
	@RequestMapping(value = "/boardUpdateForm", method = RequestMethod.GET)
	public String boardUpdateForm(@RequestParam("boardNum") int boardNum, Model model){
		model.addAttribute("board", service.boardDetail(boardNum));
		return "boardUpdate";
	}
	
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(Board upt, Model model) {
		model.addAttribute("board", service.boardUpdate(upt));
		model.addAttribute("proc","upt");
		return "boardUpdate";
	}
	
	@RequestMapping(value = "/boardDelete")
	public String boardDelete(@RequestParam("boardNum") int boardNum, Model model) {
		service.boardDelete(boardNum);
		model.addAttribute("proc","del");
		return "boardList";
	}
	
	
	

	
}
