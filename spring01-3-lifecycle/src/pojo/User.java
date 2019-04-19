package pojo;

//用于测试user对象的生命周期
public class User {

	//对象的实例化方法:创建对象
	public User() {
		// TODO Auto-generated constructor stub
		System.out.println("user对象的创建");
	}
	
	//对象的初始化方法:设置对象的属性
	public void init() {
		System.out.println("user对象的初始化");
	}
	//对象的自定义方法:具体的行为方法 具体需要做的事情
	public void sleep() {
		System.out.println("user对象的行为方法");
	}
	//对象的销毁方法:当user对象不再使用时，进行对象的消除
	public void destroy() {
		System.out.println("user对象的销毁方法");
	}
	
}
