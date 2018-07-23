package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create s session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
					
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId =1 ;
			//get a new session
			session = factory.getCurrentSession();
			//start transaction
			session.beginTransaction();
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Updating student");
			myStudent.setFirstName("Danteeswararao");
			//commit transaction
			session.getTransaction().commit();
			
			
			//New Code 
			
			session = factory.getCurrentSession();
			//start transaction
			session.beginTransaction();
			System.out.println("Updating students ...");
			
			session.createQuery("update Student set email='test@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		

	}

}
