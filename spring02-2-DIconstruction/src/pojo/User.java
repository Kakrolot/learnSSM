package pojo;
//专门用于DI依赖注入的构造方法
public class User {
	//成员变量
	private String name;
	
	private int age;
	//构造方法
	public User(String name,int age) {
		// TODO Auto-generated constructor stub
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}
