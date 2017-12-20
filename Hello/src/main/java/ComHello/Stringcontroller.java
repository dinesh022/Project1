package ComHello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Stringcontroller {
	@RequestMapping("/Hello")
public String  hello(){
		String hello="";
		return hello;
	
}
}
