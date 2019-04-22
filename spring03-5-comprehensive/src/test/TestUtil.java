package test;

import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.ProductController;
import dao.ProductDao;
import pojo.Product;
import service.ProductService;

public class TestUtil {

	ApplicationContext context = null;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	//��Ԫ���� model�������ģ��
	@Test
	public void test01(){
		Product prod = (Product) context.getBean("product");
		System.out.println(prod);
	}
	//��Ԫ����dao������ݷ��ʺͲ���
	@Test
	public void test02() {
		ProductDao dao = (ProductDao) context.getBean(ProductDao.class);
		Product prod = (Product) context.getBean("product");
		dao.addProduct(prod);
	}
	@Test
	public void test03(){
		ProductService pService = (ProductService) context.getBean(ProductService.class);
		pService.addProduct(null);
	}
	@Test
	public void test04(){
		ProductController pController = context.getBean(ProductController.class);
		Product prod = (Product) context.getBean("product");
		pController.addProduct(prod);
	}
}
