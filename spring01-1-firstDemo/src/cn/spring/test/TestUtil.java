package cn.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.pojo.Hello;

//单元测试的工具类
public class TestUtil {
	
	@Test
	public void test01() {
		//spring的IOC，进行对象的创建
		/*1.加载配置文件(加载时,spring自动创建对象到内存)
		 *2.通过javaBean对象（通过<bean id = "hello">）
		 * 
		 */
		//AppliacationCOntext专门进行配置文件的加载
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//<bean id = "hello" --- 对应---getBean (id的值)
		Hello hello = (Hello)context.getBean("hello");
		hello.say();
		
	}
	@Test
	public void test02() {
		/*1.加载配置文件
		 *2.获取javaBean的对象(通过<bean class = "cn.spring.pojo.Hello">)
		 *
		 * 
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//不需要进行强制转换 对应getBean(类名.class)
		Hello hello = context.getBean(Hello.class);
		hello.say();
	}
	
	public void test03() {
		/*1.加载配置文件
		 *   //先在配置文件中，配置一个别名标签
		 * 2.获取javaBean的对象（通过别名标签)
		 * 
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello = (Hello) context.getBean("小白");
		hello.say();
				
	}
	//成员变量，也是全局变量
	ApplicationContext context = null;
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	@Test//两个相同id的bean
	public void test04() {
		Hello hello = (Hello) context.getBean("helloA");
		System.out.println(hello);
	}
	/*@Test
	public void test05() {//相同class的Bean
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello = context.getBean(Hello.class); 
		System.out.println(hello);
	}*/
	
}
