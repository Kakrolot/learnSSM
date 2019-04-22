package dao;

import pojo.Product;

//接口:没有具体的方法体
//    只有需要实现的方法
//作用:程序员会根据开发经验，先把需要处理的方法或者代码，定义成接口
//接口其实就相当于一张图纸/一个计划表
public interface ProductDao {
	//插入一条数据的方法
	public void addProduct(Product prod);
	

}
