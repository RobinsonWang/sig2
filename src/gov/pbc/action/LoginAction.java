package gov.pbc.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import gov.pbc.model.User;
import gov.pbc.service.LoginService;

public class LoginAction extends ActionSupport{
	@Resource
	private LoginService loginService;
	
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
	  
    @Override
    public String execute() throws Exception {
        System.out.println("ִ��Action");
         
        return SUCCESS;
    }
     
    //�����Զ��巽��
    public String login() {
    	List<User> userList = loginService.getUserByUsername(username);
    	for(User user: userList){
    		if(password.trim().equals(user.getPassword())){
    			return "success";
    		}
    	}
    	
        return "fail";
    }

}
