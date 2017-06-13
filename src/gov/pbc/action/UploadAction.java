package gov.pbc.action;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

import gov.pbc.model.Student;
import gov.pbc.service.StudentService;
import jxl.Sheet;
import jxl.Workbook;

public class UploadAction extends ActionSupport{
	@Resource
	private StudentService studentService;
	
	//注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File file;
    
    //提交过来的file的名字
    private String fileFileName;
    
    //提交过来的file的MIME类型
    private String fileContentType;
	
    
    
	public File getFile() {
		return file;
	}



	public void setFile(File file) {
		this.file = file;
	}



	public String getFileFileName() {
		return fileFileName;
	}



	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}



	public String getFileContentType() {
		return fileContentType;
	}



	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}



	public void fileupload() throws Exception{
		String filepath = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println("filepath: "+filepath);
		System.out.println("fileFileName: " + fileFileName);
		String inputfile = filepath+"\\"+fileFileName;
		System.out.println(inputfile);
        if (file != null) {
            File savefile = new File(new File(filepath), fileFileName);
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            FileUtils.copyFile(file, savefile);
            
        }
        
        insertDataFromExcel(inputfile);
	}
	
	public void insertDataFromExcel(String inputfile){
		
		try{
			Workbook rwb=Workbook.getWorkbook(new File(inputfile));
			Sheet rs=rwb.getSheet(0);
			int clos=rs.getColumns();//得到所有的列
			int rows=rs.getRows();//得到所有的行
			System.out.println("clos: "+clos+" rows:"+rows);
			for (int i = 0; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String name=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String age=rs.getCell(j++, i).getContents();
                    
                    System.out.println("name:"+name+" age:"+age);
                    Student stu = new Student();
                    stu.setName(name);
                    stu.setAge(Integer.parseInt(age));
                    studentService.addStudent(stu);
                }
            } 
			 
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
