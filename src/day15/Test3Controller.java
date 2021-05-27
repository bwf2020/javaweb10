package day15;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test3Controller{

	
	public Test3Controller() {
		
		
		System.out.println("test3被实例化了................");
		
		
	}
	
	@RequestMapping("/test1.do")
	public String test1() {
		
		System.out.println("day15 test3 请求 test1.......................");
		return "index";
		
	}
	
	@RequestMapping("/test2.do")
	public String test2() {
		
		System.out.println("day15 test3 请求  test2.......................");
		return "index";
		
	}
	
	@RequestMapping("/test3")
	public String test3() {
		
		System.out.println("day15 test3 请求  test3.......................");
		return "index";
		
	}
	
	
	@RequestMapping("/test4")
	public String test4(String name) {
		
		System.out.println("day15 test3 请求  test4.......................");
		System.out.println("参数："+name);
		return "index";
		
	}
	
	
	@RequestMapping("/test5")
	public ModelAndView test5(String name) {
		
		System.out.println("day15 test3 请求  test5.......................");
		System.out.println("参数："+name);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("name", name.toUpperCase());
		
		return mv;
		
	}
	
	@RequestMapping("/test6")
	public ModelAndView test6(HttpServletRequest req,HttpServletResponse resp,HttpSession session, String name) {
		
		System.out.println("day15 test3 请求  test6.......................");
		System.out.println("参数："+name);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("name", name.toUpperCase());
		
		return mv;
		
	}
	
	@RequestMapping("/test7")
	public ModelAndView test7(HttpServletRequest req,int a) {
		
		String p=req.getParameter("a");
		
		System.out.println("day15 test3 请求  test7.......................");
		System.out.println("参数："+(a+1));
		System.out.println("原来方式参数："+(p+1));
		System.out.println("原来方式参数："+(Integer.parseInt(p)+1));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		
		
		return mv;
		
	}
	
	
	
	@RequestMapping("/test8")
	public ModelAndView test8(@RequestParam(value="a",required=false,defaultValue="0") int a) {
		
		
		
		System.out.println("day15 test3 请求  test8 .......................");
		System.out.println("参数："+a);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		
		
		return mv;
		
	}
	
	
	@RequestMapping("/test9")
	public ModelAndView test9(@RequestParam(required=true) Integer a) {
		
		
		
		System.out.println("day15 test3 请求  test9 .......................");
		System.out.println("参数："+a);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		
		
		return mv;
		
	}
	
	
	@RequestMapping("/test10")
	public ModelAndView test10(User user) {
		
		
		
		System.out.println("day15 test3 请求  test10 .......................");
		System.out.println("参数："+user);
		
		System.out.println(user.getA());
		System.out.println(user.getF());

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		
		
		return mv;
		
	}
	
	@RequestMapping("/test11")
	public ModelAndView test11(User user) {
		
		
		
		System.out.println("day15 test3 请求  test11 .......................");
		System.out.println("参数："+user);
		
		System.out.println(user.getA());
		System.out.println(user.getF());

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		
		
		return mv;
		
	}
	
	
	@RequestMapping("/test12")
	public ModelAndView test12(User user) {
		
		
		
		System.out.println("day15 test3 请求  test12 .......................");
		System.out.println("参数："+user);
		
	/*	System.out.println(user.getName());
		System.out.println(user.getDog());
		System.out.println(user.getDog().getName());
		
		System.out.println(Arrays.toString(user.getArray()));
		
		System.out.println(user.getList());*/
		
		System.out.println(user.getMap());

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		
		
		return mv;
		
	}
	
	
	@RequestMapping("/test13")
	public ModelAndView test13(@RequestParam String[] array) {
		
		
		System.out.println("day15 test3 请求  test13 .......................");
		System.out.println(Arrays.toString(array));

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/test14")
	public ModelAndView test14(@RequestParam List list) {
		
		
		System.out.println("day15 test3 请求  test14 .......................");
		System.out.println(list);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/test15")
	public ModelAndView test15(User user) {
		
		
		System.out.println("day15 test3 请求  test15 .......................");
		System.out.println(user);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/test16")
	public ModelAndView test16(String a) {
		
		
		System.out.println("day15 test3 请求  test16 .......................");
		System.out.println(a);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/test17")
	public ModelAndView test17(@RequestParam String a) {
		
		
		System.out.println("day15 test3 请求  test17 .......................");
		System.out.println(a);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	
	@RequestMapping("/test18")
	public ModelAndView test18(@RequestParam("list2") List list) {
		
		
		System.out.println("day15 test3 请求  test18 .......................");
		System.out.println(list);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/test19")
	public ModelAndView test19(@RequestParam Map map) {
		
		
		System.out.println("day15 test3 请求  test19 .......................");
		System.out.println(map);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/test20")
	public ModelAndView test20(@DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		
		
		System.out.println("day15 test3 请求  test20 .......................");
		System.out.println(date);

		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
}
