package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;

import dao.StudentDAO;
import model.Student;

public class StudentAction {
	
	private File image;
	private String imageFileName;
	private String imageContentType;
	
	private Student student;
	StudentDAO dao=new StudentDAO();
	
	HttpServletRequest request=ServletActionContext.getRequest();
	
	public Student getStudent() {
		return student;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * student register method
	 * @return
	 */
	public String register(){
		dao.update(student);
		return "main";
	}
	/**
	 * student login method
	 * @return
	 */
	public String login(){
		Student stu=dao.login(student);
		if(stu==null){
			return "login";
		}
		/**
		 * information session save method one
		 */
//		HttpServletRequest request=ServletActionContext.getRequest();
//		HttpSession session=request.getSession();
//		session.setAttribute("STUDENTS", stu);
		
		/**
		 * information session save method two
		 */
		ActionContext.getContext().getSession().put("STUDENT", stu);
		return "main";
	}
	/**
	 * judgment password Action method
	 * @return
	 * @throws IOException
	 * 0=false,1=true
	 */
	public String checkpwd() throws IOException{
		String result="0";
		if(dao.checkpwd(student)){
			result="1";
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		PrintWriter out=response.getWriter();
		out.print(result);
		return null;
	}
	/**
	 * update user information
	 * @return
	 * @throws IOException 
	 */
	public String update() throws IOException{
		if(image!=null){
		String fileName="uploadfiles";
		String url=fileName;
		fileName=request.getServletContext().getRealPath("")+fileName;
		File file=new File(fileName);
		if(!file.exists()){
			file.mkdir();
		}
		
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		fileName=fileName+"\\"+year;
		url=url+"\\"+year;
		file=new File(fileName);
		if(!file.exists()){
			file.mkdir();
		}
		
		int month=cal.get(Calendar.MONTH)+1;
		fileName=fileName+"\\";
		url=url+"\\";
		if(month<10){
			fileName=fileName+"0";
		}
		fileName=fileName+month;
		url=url+month;
		file=new File(fileName);
		if(!file.exists()){
			file.mkdir();
		}
		
		int day=cal.get(Calendar.DAY_OF_MONTH);
		fileName=fileName+"\\";
		url=url+"\\";
		if(day<10){
			fileName=fileName+"0";
		}
		fileName=fileName+day;
		url=url+day;
		
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<10){
			fileName=fileName+"0";
		}
		fileName=fileName+hour;
		url=url+hour;
		
		int minute=cal.get(Calendar.MINUTE);
		if(minute<10){
			fileName=fileName+"0";
		}
		fileName=fileName+minute;
		url=url+minute;
		
		int second=cal.get(Calendar.SECOND);
		if(second<10){
			fileName=fileName+"0";
		}
		fileName=fileName+second;
		url=url+second;
		
		int millisecond=cal.get(Calendar.MILLISECOND);
		if(millisecond<10){
			fileName=fileName+"0";
		}
		if(millisecond<100){
			fileName=fileName+"0";
		}
		fileName=fileName+millisecond;
		url=url+millisecond;
		
		String extension=imageFileName.substring(imageFileName.indexOf("."));
		fileName=fileName+extension;
		url=url+extension;
		file=new File(fileName);
		System.out.println(fileName);
		FileUtils.copyFile(image, file);
		//before the photo path,if not empty, to speak of its deleted
		String oldurl=dao.getUrl(student);
		if(oldurl!=null){
			String oldfile=request.getServletContext().getRealPath("")+oldurl;
			File myfile=new File(oldfile);
			if(myfile.exists()){
		      	myfile.delete();
			}
		}
		student.setPhoto(url);
	}
		dao.update(student);
		
		HttpSession session=request.getSession();
		session.setAttribute("STUDENT", student);
		return "main";
	}
}