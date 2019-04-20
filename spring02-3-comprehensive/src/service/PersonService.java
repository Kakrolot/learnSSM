package service;

import dao.PersonDao;
import pojo.Person;

public class PersonService {
	//成员变量
	private PersonDao dao;
	//set方法，进行Spring的DI依赖注入
	public void setDao(PersonDao dao) {
		this.dao = dao;
	}

	//自定义方法,完成调用dao层的逻辑
	public void  addPerson(Person person) {
		dao.addPerson(person);
	}
}
