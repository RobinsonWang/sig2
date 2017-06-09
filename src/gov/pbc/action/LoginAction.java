package gov.pbc.action;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import gov.pbc.model.Student;
import gov.pbc.model.User;
import gov.pbc.service.StudentService;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	private String username;
	private String password;
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
    	List<User> userList = studentService.findAll();
    	User user = new User();
    	Iterator<User> it = userList.iterator();
    	while(it.hasNext()){
    		user = it.next();
    		if(username.trim().equals(user.getUsername()) && 
    				password.trim().equals(user.getPassword())){
    			return "success";
    		}
    	}
    	
    	
        return "fail";
    }

}
