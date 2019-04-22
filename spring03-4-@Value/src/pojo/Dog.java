package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Dog {
	@Value(value = "Ð¡°×")
	private String name;
	@Value(value = "2")
	private int age;
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}

}
