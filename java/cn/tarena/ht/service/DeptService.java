package cn.tarena.ht.service;

import java.util.List;



import cn.tarena.ht.pojo.Dept;

public interface DeptService {
	//��ѯ�б�
	public List<Dept> queryDepts();
	public void updateStateById(int state,String[] deptId);
	public void deleteBydeptId(String[] deptId);
	public void save(Dept dept);
	//���水ť
	//������ͻ
	public Dept queryById(String deptId);
	//�鿴����
	public Dept queryDepartmentById(String deptId);
	//�޸Ĳ���ȷ�ϰ�ť
	public void updateDepartmentById(Dept dept);

}
