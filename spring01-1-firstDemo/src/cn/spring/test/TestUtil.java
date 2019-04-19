package cn.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.pojo.Hello;

//��Ԫ���ԵĹ�����
public class TestUtil {
	
	@Test
	public void test01() {
		//spring��IOC�����ж���Ĵ���
		/*1.���������ļ�(����ʱ,spring�Զ����������ڴ�)
		 *2.ͨ��javaBean����ͨ��<bean id = "hello">��
		 * 
		 */
		//AppliacationCOntextר�Ž��������ļ��ļ���
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//<bean id = "hello" --- ��Ӧ---getBean (id��ֵ)
		Hello hello = (Hello)context.getBean("hello");
		hello.say();
		
	}
	@Test
	public void test02() {
		/*1.���������ļ�
		 *2.��ȡjavaBean�Ķ���(ͨ��<bean class = "cn.spring.pojo.Hello">)
		 *
		 * 
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//����Ҫ����ǿ��ת�� ��ӦgetBean(����.class)
		Hello hello = context.getBean(Hello.class);
		hello.say();
	}
	
	public void test03() {
		/*1.���������ļ�
		 *   //���������ļ��У�����һ��������ǩ
		 * 2.��ȡjavaBean�Ķ���ͨ��������ǩ)
		 * 
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello = (Hello) context.getBean("С��");
		hello.say();
				
	}
	//��Ա������Ҳ��ȫ�ֱ���
	ApplicationContext context = null;
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	@Test//������ͬid��bean
	public void test04() {
		Hello hello = (Hello) context.getBean("helloA");
		System.out.println(hello);
	}
	/*@Test
	public void test05() {//��ͬclass��Bean
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hello hello = context.getBean(Hello.class); 
		System.out.println(hello);
	}*/
	
}
