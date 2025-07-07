package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	
	@RequestMapping("/add_product")
	public String add_product_form() {
		return "add_product_form";
	}

}
