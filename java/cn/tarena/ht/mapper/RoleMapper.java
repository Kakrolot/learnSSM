package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.tarena.ht.pojo.Role;

//ר�����ڷ��ʺ���ɾ�Ĳ����ݿ�
public interface RoleMapper {
	//ֻ�����ڼ򵥵�sql����ѯ
	//��������鵥������
	@Select("select *, role_id as id,'' as p_id from role_p")
	//@Update("")
	//@Insert("")
	//@Delete("")
	public List<Role> queryRoles();
	//ɾ���м��role_module_p
	public void deleteModuleIdByRoleId(String roleId);
	//���������м��
	public void saveRoleModule(@Param("roleId")String roleId,
							   @Param("moduleIds")String[] moduleIds);
}
