package service;

import dao.PersonDao;
import pojo.Person;

public class PersonService {
	//��Ա����
	private PersonDao dao;
	//set����������Spring��DI����ע��
	public void setDao(PersonDao dao) {
		this.dao = dao;
	}

	//�Զ��巽��,��ɵ���dao����߼�
	public void  addPerson(Person person) {
		dao.addPerson(person);
	}
}
