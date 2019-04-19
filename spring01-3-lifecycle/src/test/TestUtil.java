package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;

public class TestUtil {
	@Test
	public void test01(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) context.getBean("user");
		user.sleep();
		//如果要测试销毁对象的方法
		//需要使用close方法关闭对象context
		//在使用close方法时需要修改context类型
		context.close();
		
	}

}
