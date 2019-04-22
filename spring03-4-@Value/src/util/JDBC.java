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

@Component//ר������model��ע��
@Controller//ר�����ڿ��Ʋ�ע��
@Service   //ר������ҵ���ע��
@Repository //ר������dao���ע��
@Lazy(true)   //����������ģʽ
@Scope("prototype")//���ڶ�������
public class JDBC {
	@Value("${jdbc.driver}")
	private String driver;//����
	
	
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
