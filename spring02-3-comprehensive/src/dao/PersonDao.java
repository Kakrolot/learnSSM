package dao;

import pojo.Person;

//���ݷ��ʲ㣬������ɾ�Ĳ�
public class PersonDao {
	
	//dao��,������pojo Ҳ����Person����
	//ע��,person�����������ݵķ�װ
	public void addPerson(Person person) {
		System.out.println("�ɹ������һ���û�:"+person);
	}

}
