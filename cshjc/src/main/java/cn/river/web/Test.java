package cn.river.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.mongodb.MongoClient;

//import com.mongodb.MongoClient;

@Controller
public class Test {
	
	@RequestMapping(value = "/test")
	public String test() {
		try{
			System.out.println("aaaa");
//			MongoClient mongoClient = new MongoClient( "localhost" , 27017);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "jsp/test";
	}
}
