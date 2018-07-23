package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create s session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
					
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session to save the objects
			//get the instructor by primary key
			
			//Start transaction 
			session.beginTransaction();
			
			//get the instructor details 
			int theId = 1;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("\n\n\n Instructor Details \n\n\n");
			System.out.println(theInstructorDetail);
			//print the associated instructor
			
			System.out.println("\n\n\n Associated Instructor Details \n\n\n");
			System.out.println(theInstructorDetail.getInstructor());
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		

	}

}
