package pojo;

//���ڲ���user�������������
public class User {

	//�����ʵ��������:��������
	public User() {
		// TODO Auto-generated constructor stub
		System.out.println("user����Ĵ���");
	}
	
	//����ĳ�ʼ������:���ö��������
	public void init() {
		System.out.println("user����ĳ�ʼ��");
	}
	//������Զ��巽��:�������Ϊ���� ������Ҫ��������
	public void sleep() {
		System.out.println("user�������Ϊ����");
	}
	//��������ٷ���:��user������ʹ��ʱ�����ж��������
	public void destroy() {
		System.out.println("user��������ٷ���");
	}
	
}
