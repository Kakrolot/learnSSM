package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;

public class TestUtil {

	//��Ա����
	ApplicationContext context = null;
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void tset01() {
		User user1 = (User) context.getBean("user");
		User user2 = (User) context.getBean("user");
		System.out.println(user1);
		System.out.println(user2);
	//����user������ڴ��ַ��ͬ   ��ʾspring Ĭ�ϵĴ��������ǵ���ģʽ
		
	}
}
