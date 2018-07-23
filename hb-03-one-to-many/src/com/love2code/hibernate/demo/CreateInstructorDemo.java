package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create s session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
					
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session to save the objects
			//Create a  Object
			Instructor tempInstructor = new Instructor("Dantesh" ,"Patnana","danteshkumar@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://danteshkumar.blogspot.com","Love to Code !!!!");
			
			//Instructor tempInstructor = new Instructor("Harshitha" ,"Kalla","kalla.harshitha@gmail.com");
			//InstructorDetail tempInstructorDetail = new InstructorDetail("http://techoncse.blogspot.com","Love to Code !!!!");
			
			
			
			//Associate the Objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//Start transaction 
			session.beginTransaction();
			
			//Save transaction
			session.save(tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			
			session.close();
			factory.close();
		}
		

	}

}
