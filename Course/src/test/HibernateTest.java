package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import common.HibernateUtils;
import model.Student;

/**
 * 测试数据库是否可以创建成功
 * @author Sinon
 *
 */
public class HibernateTest {
	@Test
	public void testSave(){
		//这个session是用来处理数据库的与原先的session作用不一样
		Session session=HibernateUtils.openSession();
		Student s=new Student();
		s.setName("she");
		s.setPhone("13600000000");
		s.setPwd("123456");
		s.setGrade("Grade two");
		Transaction tx=session.beginTransaction();
		session.save(s);
		tx.commit();
	}
}
