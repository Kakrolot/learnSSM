package dao;

import pojo.Person;

//数据访问层，进行增删改查
public class PersonDao {
	
	//dao层,依赖于pojo 也就是Person对象
	//注意,person对象用于数据的封装
	public void addPerson(Person person) {
		System.out.println("成功添加了一个用户:"+person);
	}

}
