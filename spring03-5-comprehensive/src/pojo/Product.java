package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
	//��Ա����
	@Value("��Ʒ001")
	private String isbn;
	@Value("ղķ˹����")
	private String title;
	
	@Override
	public String toString() {
		return "Product [isbn=" + isbn + ", title=" + title + "]";
	}

}
