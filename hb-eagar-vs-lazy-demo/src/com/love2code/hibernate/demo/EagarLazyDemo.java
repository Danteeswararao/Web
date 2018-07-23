package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;


public class EagarLazyDemo {

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
			
			//Start transaction 
			session.beginTransaction();
			
			//get the instructor 
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("\n__________________________________\n");
			System.out.println("love 2 code : Instructor : " +tempInstructor);
			System.out.println("love 2 code : Course : "+tempInstructor.getCourse());
			System.out.println("\n__________________________________\n");
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("love 2 code : Done");
			
		}
		finally {
			
			session.close();
			factory.close();
		}
		

	}

}
