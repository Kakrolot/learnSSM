package pojo;

public class User {

	//引用数据类型
	private Dog dog;

	@Override
	public String toString() {
		return "User [dog=" + dog + "]";
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
}
