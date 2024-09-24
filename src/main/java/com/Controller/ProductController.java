package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dto.Productdto;
import com.factory.ServiceFactory;

@Controller
public class ProductController {
	
	@Autowired
	ServiceFactory  serviceFactory;
	
	
	@GetMapping("Addproduct")
	public String addProduct() {
		
		
		return "addproduct";
	}
	
	
	
	@PostMapping("addProduct")
	public String saveProduct(Productdto productdto) {
		
		     serviceFactory.getProductService().addProduct(productdto);
		
		return "redirect:/listproduct";
	}
	
	
	@GetMapping("listproduct")
	public String listproduct(Model model) {
		
		      List<Productdto> listproduct = serviceFactory.getProductService().listproduct();
		      model.addAttribute("listproduct",listproduct);
		
		
	  return "listproduct";
	}

}
