package com.love2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//create s session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
					
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//Start transaction 
			session.beginTransaction();
			
			//Query the students
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			//Display the students
			displayStudent(theStudent);
			
			//Display the students with last name Patnana
			System.out.println("\n\nStudents who have last name as Patnana \n ");
			theStudent = session.createQuery("from Student s where s.lastName='Patnana'").getResultList();
			displayStudent(theStudent);
			
			
			System.out.println("\n\nStudents who have last name as Patnana OR firstName as Harshitha \n ");
			theStudent = session.createQuery("from Student s where"
					+ " s.lastName='Patnana' OR s.firstName='Harshitha'").getResultList();
			displayStudent(theStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
		

	}

	private static void displayStudent(List<Student> theStudent) {
		
		for(Student tempStudent : theStudent) {
			
			System.out.println(tempStudent);
			
		}
	}

}
