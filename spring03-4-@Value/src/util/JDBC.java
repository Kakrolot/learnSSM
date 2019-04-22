package util;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component//专门用于model层注解
@Controller//专门用于控制层注解
@Service   //专门用于业务层注解
@Repository //专门用于dao层的注解
@Lazy(true)   //用于懒加载模式
@Scope("prototype")//用于多例加载
public class JDBC {
	@Value("${jdbc.driver}")
	private String driver;//驱动
	
	
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.user}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("#{@list}")
	private List list;
	@Value("#{@map}")
	private Map map;
	@Value("#{@prop}")
	private Properties prop;
	@Value("#{@set}")
	private Set set;
	@Override
	public String toString() {
		return "JDBC [driver=" + driver + ", url=" + url + ", username=" + username + ", password=" + password
				+ ", list=" + list + ", map=" + map + ", prop=" + prop + ", set=" + set + "]";
	}
}
