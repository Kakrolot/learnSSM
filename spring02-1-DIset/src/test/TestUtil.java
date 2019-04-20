package test;
//

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;

public class TestUtil {
	ApplicationContext context = null;
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void test01() {
		User user = (User) context.getBean("user");
		System.out.println(user);
	}

}
