package gov.pbc.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	  
    @Override
    public String execute() throws Exception {
        System.out.println("ִ��Action");
         
        return SUCCESS;
    }
     
    //�����Զ��巽��
    public String login() {
        return SUCCESS;
    }

}
