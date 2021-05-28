package day16;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test3Controller {

	
	@RequestMapping("/test1")
	public ModelAndView test1() {
		
		System.out.println("����test1------------------------------");
		
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("name", "beidaqingniao");
		
		
		return mv;
	}
	
	
	@RequestMapping("/test2")
	public ModelAndView test2() {
		
		System.out.println("����test2------------------------------");
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("name", "beidaqingniao");
		
		
		return mv;
	}
	
	
	@RequestMapping("/test3")
	public ModelAndView test3(String name) {
		
		System.out.println("����test3------------------------------");
		System.out.println("��������"+name);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("name", name);
		
		
		return mv;
	}
	
	
}
