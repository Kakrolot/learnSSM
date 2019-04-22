package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pojo.Product;
import service.ProductService;

@Controller
public class ProductController {
	//控制层 依赖于service层
	//需要调用service层的方法
	@Autowired
	private ProductService ps;
	public void addProduct(Product prod) {
		System.out.println("控制层开始调用service方法");
		ps.addProduct(prod);
		System.out.println("控制层结束调用service方法");
		
		
	}

}
