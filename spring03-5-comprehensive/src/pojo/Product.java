package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
	//成员变量
	@Value("商品001")
	private String isbn;
	@Value("詹姆斯哈登")
	private String title;
	
	@Override
	public String toString() {
		return "Product [isbn=" + isbn + ", title=" + title + "]";
	}

}
