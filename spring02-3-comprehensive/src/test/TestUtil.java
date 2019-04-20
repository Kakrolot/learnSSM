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
		//������Դ�Ѿ�ͨ��IOC��DI������һ������
		Person person = (Person) context.getBean("person");
		//��ȡcontroller��Ķ���
		//����Ŀ��Ʋ�,Ҳ�ǵ��õķ�����
		PersonController pc = (PersonController) context.getBean("personController");
		pc.addPerson(person);
	}

}
