package pojo;
//ר������DI����ע��Ĺ��췽��
public class User {
	//��Ա����
	private String name;
	
	private int age;
	//���췽��
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
