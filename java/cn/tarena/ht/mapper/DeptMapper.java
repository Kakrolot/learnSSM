package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Dept;

//ר��ִ��sql���
public interface DeptMapper {
	//��ѯ�б�
	public List<Dept> queryDepts();
	//����״̬:
	//����һ:state ������:deotId
	public void updateStateById(@Param(value="state") int state,
								@Param(value="deptId") String[] deptId);
	
	public void deleteById(String[] deptId);
	
	public void save(Dept dept);
	//���水ť
	//������ͻ
	public Dept queryById(String deptId);
	
	public Dept queryDepartmentById(String deptId); 
	
	public void updateDepartmentById(Dept dept);
		
	
}
