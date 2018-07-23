package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create s session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
					
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//int studentId =5 ;
			//get a new session
			session = factory.getCurrentSession();
			//start transaction
			session.beginTransaction();
			//Student myStudent = session.get(Student.class, studentId);
			//System.out.println("Deleting student");
			//session.delete(myStudent);
			System.out.println("Deleting student for Id 6");
			session.createQuery("delete from Student where id = 6").executeUpdate();
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		

	}

}
