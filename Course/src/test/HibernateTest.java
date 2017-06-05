package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import common.HibernateUtils;
import model.Student;

/**
 * �������ݿ��Ƿ���Դ����ɹ�
 * @author Sinon
 *
 */
public class HibernateTest {
	@Test
	public void testSave(){
		//���session�������������ݿ����ԭ�ȵ�session���ò�һ��
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
