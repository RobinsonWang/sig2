package gov.pbc.action;

import com.opensymphony.xwork2.ActionSupport;

import gov.pbc.model.Student;
import gov.pbc.service.StudentService;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	  
    @Override
    public String execute() throws Exception {
        System.out.println("ִ��Action");
         
        return SUCCESS;
    }
     
    //�����Զ��巽��
    public String login() {
    	Student stu = studentService.findById(1);
    	System.out.println(stu.getName());
        return SUCCESS;
    }

}
