package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.HibernateUtils;
import model.Student;

public class StudentDAO {
	Session session;
	String hql;
	/**
	 * student registerdao method and update method
	 * @param student
	 */
	public void update(Student student){
		//get session
		session=HibernateUtils.openSession();
		//start transaction
		Transaction tx=session.beginTransaction();
		//save object
		session.saveOrUpdate(student);;
		//submit transaction
		tx.commit();
		//close session
		session.close();
	}
	/**
	 * Student logindao method
	 * @param student
	 * @return student
	 */
	public Student login(Student student){
		//open session 
		session=HibernateUtils.openSession();
		hql="from Student where name=:name and pwd=:pwd";
		//Query query=session.createQuery(hql);
		//method one
        //query.setString("name", student.getName());
        //query.setString("pwd", student.getPwd());
		//method two
		//query.setProperties(student);
		//method three
		Query query=session.createQuery(hql).setProperties(student);
		//get all student table information
		@SuppressWarnings("unchecked")
		List<Student> list=query.list();
		student=null;
		if(list.size()>0){
			student=list.get(0);
		}
		return student;
	}
	/**
	 * judgment password
	 * @param student
	 * @return
	 */
	public boolean checkpwd(Student student){
		session=HibernateUtils.openSession();
		hql="from Student where id=:id and pwd=:pwd";
		Query query=session.createQuery(hql).setProperties(student);
		@SuppressWarnings("unchecked")
		List<Student> list=query.list();
		session.close();
		return list.size()>0?true:false;
	}
}
