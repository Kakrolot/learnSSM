package cn.tarena.ht.pojo;

public class Module extends BaseEntity{
	//��Ա����
	private String moduleId;
	private String name;
	private Integer ctype;
	private Integer state;
	private Integer orderNo;
	private String remark;
	//��Ա����:��������
	//����һ��һ���Թ���
	private Module parentModule;
	
	//zTree����������ֶ�
	private String id;//��ǰ�ڵ��id
	private String pId;//��ǰ�ڵ�ĸ��ڵ�
	private Boolean checked;//��ѡ��Ĺ�ѡ
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Module getParentModule() {
		return parentModule;
	}
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", name=" + name + ", ctype=" + ctype + ", state=" + state
				+ ", orderNo=" + orderNo + ", remark=" + remark + ", parentModule=" + parentModule + ", id=" + id
				+ ", pId=" + pId + ", checked=" + checked + "]";
	}
	

}
