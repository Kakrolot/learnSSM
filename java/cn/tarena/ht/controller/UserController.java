package cn.tarena.ht.controller;

import java.io.IOException;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user/")
public class UserController extends BaseController{
	//��Ա��������ע��service��
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleService roleService;
	
	//1.�û�����Ķ�λ�б�ҳ��
	@RequestMapping("list")
	public String toListJSP(Model model) {
		
		
		//�Ȳ�ѯ���ݿ�
		List<User> list = userService.queryUsers();
		
		//model�������ݵķ�װ
		model.addAttribute("userList",list);
		
		return "/sysadmin/user/jUserList";
	}
	
	//2.���Ź���Ķ�λ�鿴ҳ��
	@RequestMapping("toViewJSP")
	public String toViewJSP(String userId,Model model) {
		//�Ȳ�ѯ���ݿ⣬��ȡ�û�����ϸ��Ϣ
		User user = userService.queryManagerById(userId);
		System.out.println(user);
		model.addAttribute("user",user);
		//ʹ��model�������ݵİ�
		return "/sysadmin/user/jUserView";
	}
	
	//3.�û�����λ�޸�ҳ��
	@RequestMapping("toUpdateJSP")
	public String toUpdateJSP(String userId,Model model) {
		
		//���µ���Ϣ���Ȳ�ѯ���ݿ�
		
		//3.1��ѯuser�������ϸ��Ϣ
		User user = userService.queryManagerById(userId);
		//3.2��ѯ���еĲ�����Ϣ��Ϊ�ϼ�����
		List<Dept> depts = deptService.queryDepts();
		//3.3��ѯ���е��û�������Ϊ�ϼ��쵼
		List<User> superior = userService.queryUsers();
		
		//ʹ��model�����װ������������
		model.addAttribute("user",user);
		model.addAttribute("deptList",depts);
		model.addAttribute("userInfoList",superior);
		
		return "/sysadmin/user/jUserUpdate";
	}
	
	@RequestMapping("update")
	public String update(User user,Model model) {
		userService.updateUserById(user);
		model.addAttribute("user",user);
		//�ض���:List����
		return "redirect:/sysadmin/user/list";
	}
	//4.��ɫ��������ͣ��
	//4.1ͣ��
	@RequestMapping("stop")
	public String stop(@RequestParam(defaultValue="4" ,value="userId") String[] userId) {
		int state=0;
		userService.updateStateById(state, userId);
		
		return "redirect:/sysadmin/user/list";
	}
	@RequestMapping("start")
	public String start(@RequestParam(defaultValue="4" ,value="userId") String[] userId) {
		int state=1;
		userService.updateStateById(state, userId);
		
		return "redirect:/sysadmin/user/list";
	}
	//5.��ɫ��ɾ��
	@RequestMapping("delete")
	public String delete(@RequestParam(defaultValue="4", value="userId")String[] userId){
		userService.deleteUserById(userId);
		return "redirect:/sysadmin/user/list";
	}
	//6.1��ɫ����������
	@RequestMapping("toSaveJSP")
	public String toSaveJSP(Model model){
		//��ѯ���ݿ��ò�����Ϣ���ϼ��쵼��Ϣ
		List<User> userInfoList = userService.queryUsers();
		
		List<Dept> deptList = deptService.queryDepts();
		model.addAttribute("deptList",deptList);
		model.addAttribute("userInfoList",userInfoList);
		return "/sysadmin/user/jUserSave";
	}
	/*//6.2�û������ı���
	@RequestMapping("save")
	public String save(){
		return "redirect:/sysadmin/user/list";
	}*/
	//7.1�û����� ����ɫ��ť
	//ҳ��չʾzTree��
	@RequestMapping("toRoleJSP")
	public String toRoleJSP(String userId,Model model) throws IOException {
		
		//1.�Ȳ�ѯ���ݿ�,�õ����е�role��ɫ��Ϣ
		List<Role> roles = roleService.queryRoles();
		//1.1��ѯ��ǰ�û��µ�ӵ�еĽ�ɫ
		List<String> roleList = userService.queryRoleIdByUserId(userId);
		for (String roleId : roleList) {//ѭ����ӵ�н�ɫ
			for(Role role:roles){//ѭ�����н�ɫ
				if(roleId.equals(role.getRoleId())){
					//���ƥ��ɹ�����Ҫ����zTree����check����
					role.setChecked(true);
				}
			}
		}
		model.addAttribute("userId",userId);
		//2.��list����ת��ΪzTree����json�����ʽ
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJson = objectMapper.writeValueAsString(roles);
		System.out.println("========"+zTreeJson);
		
		model.addAttribute("zTreeJson",zTreeJson);
		//3.ʹ��model���󣬷�װjson����
		return "/sysadmin/user/jUserRole";
	}
	//8.�û�����ı����ɫ��ť'\
	@RequestMapping("saveUserRole")
	public String saveUserRole(String userId,String roleIds,Model model) {
		//1.�ж��û���id�Ƿ�Ϊ��
		
		if (userId == null || "".equals(userId)) {
			//���ܽ������ݵı�����
			model.addAttribute("msg","�û�id����Ϊ�գ��빴ѡһ��Ա��");
			return "forward:/sysadmin/user/toRoleJSP";
		}
		//2.����service��ķ�������������
		//roleIds:�������ʽ���ַ���
		userService.saveUserRole(userId, roleIds.split(","));
		return "redirect:/sysadmin/user/list";
	}

}
