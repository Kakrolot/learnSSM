package controller;
//���Ʋ㣬ר�Ŵ���Ϳ��������
//��Ҫ����service��ķ���

import pojo.Person;
import service.PersonService;

public class PersonController {
	//��Ա����
	private PersonService personService;
	//���set����,����spring��DI����ע��
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	//�Զ��巽��,����service�㷽��
	public void addPerson(Person person) {
		personService.addPerson(person);
	}
}
	
