package pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class User {
	@Autowired
	private Cat cat;
	@Autowired
	private Dog dog;
	@Override
	public String toString() {
		return "User [cat=" + cat + ", dog=" + dog + "]";
	}
	

}
