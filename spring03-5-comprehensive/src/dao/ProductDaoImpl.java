package dao;

import org.springframework.stereotype.Repository;

import pojo.Product;
@Repository
public class ProductDaoImpl implements ProductDao{

	@Override
	public void addProduct(Product prod) {
		// TODO Auto-generated method stub
		System.out.println("成功的购买了一个商品"+prod);
	}

}
