package cn.tarena.ht.pojo;

//���ݿ��е��ֶ� ---��Ӧ�ų�Ա����
//��Ҫ�̳г����࣬��ɹ�ͬ���ֶ�
public class Dept extends BaseEntity{
	//��Ա����:dept_p����е��ֶ�
	private String deptId;//�������ܳ�ͻ
	private String parentId;//�ò��ŵ��ϼ�����
	private String deptName;//��������
	private Integer state;//����״̬ ��0ͣ�� 1����
	
	public void setState(Integer state) {
		this.state = state;
	}
	//�Թ����Ĺ�ϵ
	private Dept parentDept;//�ϼ����ŵ���Ϣ

	public Dept getParentDept() {
		return parentDept;
	}
	public void setParentDept(Dept parentDept) {
		this.parentDept = parentDept;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getState() {
		return state;
	}


}
