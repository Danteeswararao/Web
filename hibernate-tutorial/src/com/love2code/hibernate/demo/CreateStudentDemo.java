package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create s session factory
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
					
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session to save the objects
			//Create a Student Object
			System.out.println("Creating the student .....");
			Student student = new Student("Dantesh","Patnana","danteshkumar@gmail.com");
			//Start transaction 
			session.beginTransaction();
			//Save transaction
			System.out.println("Saving the student ...!");
			session.save(student);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}
		

	}

}
