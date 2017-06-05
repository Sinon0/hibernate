package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import dao.StudentDAO;
import model.Student;

public class StudentAction {
	private Student student;
	StudentDAO dao=new StudentDAO();
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * student register method
	 * @return
	 */
	public String register(){
		dao.register(student);
		return "main";
	}
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
}
