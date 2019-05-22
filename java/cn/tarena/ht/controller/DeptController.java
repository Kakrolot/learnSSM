package cn.tarena.ht.controller;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;
import net.sf.json.JSONObject;

@Controller
public class DeptController {
	//��Ҫ����ע��service
	@Autowired
	private DeptService deptService;
	//1.���Ź���--->�б�չʾ
	@RequestMapping("/sysadmin/dept/list")
	public String toListJSP(Model model) {
		//�Ȳ�ѯ���ݿ⣬�õ������
		List<Dept> list = deptService.queryDepts();
		//�������ݷ�װ�Ͱ�	
		model.addAttribute("deptList",list);
		//ҳ����ת
		return "/sysadmin/dept/jDeptList";
	}
	
	//2.���Ź���-����ͣ��
	@RequestMapping("/sysadmin/dept/stop")
	//����Ϊ:��ѡ�����͵�����,��������ͣ��
	public String stop(
			@RequestParam(defaultValue="4", value="deptId" ) 
			String[] deptId) {
		//stop��������ֹͣ״̬
		int state = 0;
		//����service�ķ���
		deptService.updateStateById(state, deptId);
		//������ض���
		return "redirect:/sysadmin/dept/list";
		
	}
	
	@RequestMapping("/sysadmin/dept/start")
	public String start(
			@RequestParam(defaultValue="4" ,value="deptId") 
			String[] deptId) {
		//stop��������ֹͣ״̬
		int state = 1;
		//����service�ķ���
		deptService.updateStateById(state, deptId);
		//������ض���
		return "redirect:/sysadmin/dept/list";
		
	}
	@RequestMapping("/sysadmin/dept/delete")
	public String delete(@RequestParam(defaultValue="4" ,value="deptId") String[] deptId) {
		deptService.deleteBydeptId(deptId);
		return "redirect:/sysadmin/dept/list";
	}
	
	//4.���Ź���:������ť--��λҳ��
	@RequestMapping("/sysadmin/dept/toSaveJSP")
	public String toSaveJSP(Model model) {
		//�Ȳ�ѯ���ݿ⣬��ȡ������Ϣ
		List<Dept> list = deptService.queryDepts();
		//���ϼ����ŵ����ݷ�װ��model��
		//key������ҳ���е�name
		model.addAttribute("parentDeptList",list);
		//ҳ����ת
		return "/sysadmin/dept/jDeptSave";
		
	}
	
	//5.���Ź��� ���水ť
	@RequestMapping("/sysadmin/dept/save")
	public String save(Dept dept,Model model) {
		//��ȡdeptId
		String deptId = dept.getDeptId();
		//�ǿ�У��
		if(deptId ==null||"".equals(deptId)){
			//ʹ��model��װһ��������Ϣ��ʾ
			model.addAttribute("errorInfo","���ű�Ų���Ϊ��");
			//���û��id��Ϣ����ô���ص�ǰҳ��
			//����1:return "/sysadmin/dept/jDeptSave";
			//����2:�ض���toSaveJSPҳ��
			//      �����ض����ܹ�Я������
			//return "redirect:/sysadmin/dept/toSaveJSP";
			//����3:ʹ��ת����toSaveJSP���󣡣�
			return "forward:/sysadmin/dept/toSaveJSP";
			
	
		}
		//������ͻ��У��
		Dept check = deptService.queryById(deptId);
		if(check != null){
			
			return "forward:/sysadmin/dept/toSaveJSP";
		}
		deptService.save(dept);
		//�����ض���:list����ˢ���б�
		return "redirect:/sysadmin/dept/list";
	}
	
	//6.���Ź���:����--ajaxУ��
	@RequestMapping("/sysadmin/dept/checkDeptId")
	@ResponseBody//��ע��ר�����ڷ���ajax�Ľ��
	public JSONObject checkDeptId(String deptId) {
		JSONObject json = new JSONObject();
		//��ѯ���ݿ�,����deptId��ȡ����
		Dept dept = deptService.queryById(deptId);
		//�ж�dept�����Ƿ�Ϊ��
		if (dept==null) {//��ʾ���ű�ſ���ʹ��
			json.put("result", "false");
			
		}else {
			//��ʾ���ű���Ѵ���
			json.put("result", "true");
		}
		
		//ajax�첽�����ؽ������һ������
		//����һ�� json����
		//���������{result:true}/{result:false}
		return json;
	}
	
	//7.���Ų鿴����
	@RequestMapping("/sysadmin/dept/toViewJSP")
	public String tojDeptView(String deptId,Model model) {
		Dept dept = deptService.queryDepartmentById(deptId);
		model.addAttribute("dept",dept);
		return "/sysadmin/dept/jDeptView";
	}
	
	//8.���ŵ��޸Ľ���
	@RequestMapping("/sysadmin/dept/toUpdateJSP")
	public String toUpdateJSP(String deptId,Model model) {
		//8.1��ѯ������Ϣ
		Dept dept = deptService.queryDepartmentById(deptId);
		//8.2��װ������Ϣ
		model.addAttribute("dept",dept);
		//8.3��ѯ����װ�ϼ�������Ϣ
		List<Dept> parentList = deptService.queryDepts();
		model.addAttribute("parentDeptList",parentList);
		return "sysadmin/dept/jDeptUpdate";
	}
	//9.�޸ĵı��水ť
	@RequestMapping("/sysadmin/dept/update")
	public String update(Dept dept,Model model) {
		deptService.updateDepartmentById(dept);
		model.addAttribute("dept",dept);
		return "redirect:/sysadmin/dept/list";
	}
}
