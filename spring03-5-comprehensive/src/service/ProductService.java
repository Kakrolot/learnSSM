package service;

import pojo.Product;

public interface ProductService {
	//业务处理:增加一个商品,需要调用dao层
	public void addProduct(Product prod);

}
