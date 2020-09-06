package bs.java.ms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {


	@Value("${message}")
	private String message;
	
	@GetMapping("/hello")
	public String getConfig() {
		if (null != message)
			return message;
		return "hello";
	}
}
