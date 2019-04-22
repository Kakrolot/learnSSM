package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import pojo.Product;
@Service
public class ProductServiceImpl implements ProductService{

	//需要调用dao层的方法
	@Autowired
	//此处使用的是byType方式获取的Bean对象
	private ProductDao dao;
	@Override
	public void addProduct(Product prod) {
		// TODO Auto-generated method stub
		System.out.println("业务开始");
		dao.addProduct(prod);
		System.out.println("业务结束");
		
	}

}
