package edu.miu.cs.sis.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.miu.cs.sis.model.Student;
import edu.miu.cs.sis.util.HibernateUtil;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private SessionFactory sf;

	@Override
	public void saveStudentInfo(Student student) {
		Session session = HibernateUtil.getSession(sf);
		session.save(student);

	}

	@Override
	public List<Student> getAllStudentInfo() {
		Session session = HibernateUtil.getSession(sf);
		Criteria criteria = session.createCriteria(Student.class);

		return criteria.list();
	}

	@Override
	public void deleteStudentInfo(int id) {
		Student student = getStudentInfoById(id);
		if (student != null) {
			Session session = HibernateUtil.getSession(sf);
			session.delete(student);

		}

	}

	@Override
	public Student getStudentInfoById(int id) {
		Session session = HibernateUtil.getSession(sf);

		return (Student) session.get(Student.class, id);
	}

	@Override
	public void updateStudentInfo(Student student) {
		Session session = HibernateUtil.getSession(sf);
		session.update(student);

	}

	@Override
	public Student getStudentByStudentNameandPassword(String studentName, String password) {
		Session session = HibernateUtil.getSession(sf);
		Criteria criteria = session.createCriteria(Student.class);
		
		criteria.add(Restrictions.eq("studentName", studentName)).add(Restrictions.eq("password", password));
		return (Student) criteria.uniqueResult();
	}

	@Override
	public void resetPasswordById(Student student) {
		Session session = HibernateUtil.getSession(sf);
		session.update(student);

	}

	@Override
	public Student getStudentByEmail(String email) {
		Session session = HibernateUtil.getSession(sf);
		Criteria criteria = session.createCriteria(Student.class);
		
		criteria.add(Restrictions.eq("email", email));
		return (Student) criteria.uniqueResult();
	
	}

	

}
