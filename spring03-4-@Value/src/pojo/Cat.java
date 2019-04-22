package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Cat {
	@Value(value= "Ð¡ºÚ" )
	private String name;
	@Value(value= "10" )
	private int age;
	
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
	

}
