package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserMapper {
	public List<User> queryUsers();
	public User queryManagerById(String userId);
	public void updateUserById(User user);
	public void updateUserInfoById(UserInfo userInfo);
	public void updateStateById(@Param(value="state")int state,
								@Param(value="userId") String[] userId);
	public void deleteUserById(String[] userId);
	public void saveUserRole(@Param("userId")String userId,
							 @Param("roleIds")String[] roleIds);
	@Delete("delete from role_user_p where user_Id = #{userId} ")
	public void deleteUserRole(String userId);
	//��ѯ���û����е����н�ɫ
	//����ֵ������:����role_id�ֶεļ���
	@Select("select role_id from role_user_p where user_id=#{userId}")
	public List<String> queryRoleIdByUserId(String userId);
	
}
