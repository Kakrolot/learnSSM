package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import pojo.Product;
@Service
public class ProductServiceImpl implements ProductService{

	//��Ҫ����dao��ķ���
	@Autowired
	//�˴�ʹ�õ���byType��ʽ��ȡ��Bean����
	private ProductDao dao;
	@Override
	public void addProduct(Product prod) {
		// TODO Auto-generated method stub
		System.out.println("ҵ��ʼ");
		dao.addProduct(prod);
		System.out.println("ҵ�����");
		
	}

}
