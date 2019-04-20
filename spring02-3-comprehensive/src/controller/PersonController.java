package controller;
//控制层，专门处理和控制请求的
//需要调用service层的方法

import pojo.Person;
import service.PersonService;

public class PersonController {
	//成员变量
	private PersonService personService;
	//添加set方法,用于spring的DI依赖注入
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	//自定义方法,调用service层方法
	public void addPerson(Person person) {
		personService.addPerson(person);
	}
}
	
