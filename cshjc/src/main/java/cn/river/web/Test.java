package cn.river.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.MongoClient;

@Controller
@RequestMapping("/test")
public class Test {
	
	@RequestMapping(params = "method=test")
	public void test(HttpServletRequest request, HttpServletResponse response) {
		try{
			System.out.println("aaaa");
			MongoClient mongoClient = new MongoClient( "localhost" , 27017);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
