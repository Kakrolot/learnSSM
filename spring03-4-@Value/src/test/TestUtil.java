package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Nba;
import pojo.User;
import util.JDBC;

public class TestUtil {
	//成员变量
		ApplicationContext context = null;
		@Before
		public void before(){
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		@Test 
		public void test01(){
			User user = (User) context.getBean("user");
			System.out.println(user);
			
		}
		@Test
		public void test02() {
			JDBC jdbc = (JDBC) context.getBean("JDBC");
			System.out.println(jdbc);
		}

}
