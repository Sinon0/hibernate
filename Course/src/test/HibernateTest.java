package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import common.HibernateUtils;
import model.Student;

/**
 * 
 * @author Sinon
 */
public class HibernateTest {
	@Test
	public void testSave(){
		//Session与原先Session为不同概念，此处Session相当于数据库连接getConnection
		Session session=HibernateUtils.openSession();
		//设置对象属性信息
		Student s=new Student();
		s.setName("she");
		s.setPhone("13600000000");
		s.setPwd("123456");
		s.setGrade("Grade two");
		//做一个事务：把多个命令绑定成一个事务，要么全部执行成功，要么全部执行失败
		//session.beginTransaction()开始一个事务
		Transaction tx=session.beginTransaction();
		//将对象保存到数据库中
		session.save(s);
		//提交事务
		tx.commit();
	}
}
