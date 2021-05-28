package day16;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class Test2Controller {

	@RequestMapping("/up")
	public String up(HttpServletRequest req,String name) {
		
		
		MultipartResolver mr=new CommonsMultipartResolver();
		MultipartHttpServletRequest mreq=mr.resolveMultipart(req);
		
		MultipartFile mf=mreq.getFile("fileName");//获取文件
		
		String imngName=mf.getName();
		System.out.println(imngName);
		imngName=mf.getOriginalFilename();
		System.out.println(imngName);
		

		System.out.println("参数名字："+name);
		
		System.out.println("参数名字2："+mreq.getParameter("name"));//获取参数
		
		File f=new File("c:/file/"+name);
		try {
			
			mf.transferTo(f);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index.jsp";
	}
	
	
	@RequestMapping("/up2")
	public String up2(@RequestParam(value="fileName",required=false) MultipartFile mf,String name) {
		
		File f=new File("c:/file/a2.jpg");
		
		try {
			
			mf.transferTo(f);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("参数222222："+name);
		return "index.jsp";
	}
}
