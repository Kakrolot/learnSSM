package cn.tarena.ht.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private ModuleService moduleService;
	@RequestMapping("sysadmin/role/list")
	public String toRole(Model model) {
		
		List<Role> list = roleService.queryRoles();
		model.addAttribute("roleList",list);
		return "sysadmin/role/jRoleList";
	}
	//2.ģ�鰴ť
	@RequestMapping("sysadmin/role/toModuleJSP")
	public String toModuleJSP(String roleId,Model model) throws IOException {
		model.addAttribute("roleId",roleId);
		
		//2.1��ѯ���ݿ������е�module��Ϣ
		List<Module> modules = moduleService.queryModules();
		//2.2ʹ��ObjectMapperת������,��listת��Ϊjson�����ʽ���ֶ�
		ObjectMapper objectMapper = new ObjectMapper();
		String zTreeJson = objectMapper.writeValueAsString(modules);
		//2.3ʹ��model�����װ���ݵ�zTree��
		model.addAttribute("zTreeJson",zTreeJson);
		return "/sysadmin/role/jRoleModule";		
	}
	
	//3.��ɫ�����ģ�鱣�水ť
	@RequestMapping("sysadmin/role/saveRoleModule")
	public String saveRoleModule(String roleId,String moduleIds,Model model) {
		//3.1�ж�roleId�Ƿ�Ϊ��
		if (roleId == null||"".equals(roleId)) {
			//��װ������ʾ��Ϣ
			model.addAttribute("msg","��ɫ��id��Ų���Ϊ��");
			//ת��������Ϣ��:toModuleJSPҳ����������
			return "forword:/sysadmin/role/toModuleJSP";
		}
		roleService.saveRoleModule(roleId, moduleIds.split(","));
		return "redirect:/sysadmin/role/list";
		
	}
}
