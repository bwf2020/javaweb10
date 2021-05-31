package day17;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;

@Controller
public class Test1Controller {

	
	@RequestMapping("/test1")
	public ModelAndView test1(HttpSession session) {
		
		
		System.out.println("day17 test1..............");
		ModelAndView mv=new  ModelAndView();
		mv.setViewName("index");
		mv.addObject("name", "<b>²©Îª·å</b>");
		mv.addObject("sex", "ÄÐ");
		
		mv.addObject("a", 1);
		mv.addObject("b", 2);
		mv.addObject("c", true);
		
		mv.addObject("num", 88.123456);
		mv.addObject("date", new Date());
		
		mv.addObject("str", "hellobwf");
		
		User user=new User();
		user.setId(1);
		user.setName("zhangsan");
		
		mv.addObject("user", user);
		
		
		session.setAttribute("d", "sessiondata");
		
		String[] array= {"zhangsan","lisi","wangwu"};
		
		mv.addObject("array", array);
		
	
		List list=new ArrayList();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		mv.addObject("list", list);
		
		
		Map map=new HashMap();
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");
		
		mv.addObject("map", map);
		
		
		
		return mv;
	}
	
	
}
