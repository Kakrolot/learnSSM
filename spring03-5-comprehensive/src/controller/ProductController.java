package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pojo.Product;
import service.ProductService;

@Controller
public class ProductController {
	//���Ʋ� ������service��
	//��Ҫ����service��ķ���
	@Autowired
	private ProductService ps;
	public void addProduct(Product prod) {
		System.out.println("���Ʋ㿪ʼ����service����");
		ps.addProduct(prod);
		System.out.println("���Ʋ��������service����");
		
		
	}

}
