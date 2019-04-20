package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.PersonController;
import pojo.Person;

public class TestUtil {
	ApplicationContext context = null;
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void test01() {
		//数据来源已经通过IOC与DI生成了一个对象
		Person person = (Person) context.getBean("person");
		//获取controller层的对象
		//请求的控制层,也是调用的发起者
		PersonController pc = (PersonController) context.getBean("personController");
		pc.addPerson(person);
	}

}
