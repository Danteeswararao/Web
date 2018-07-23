package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Review;
import com.love2code.hibernate.demo.entity.Student;


public class DeleteDanteshStudentDemo {

	public static void main(String[] args) {
		
		//create s session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
					
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//Start transaction 
			session.beginTransaction();
			
			//get the student from db 
			int theId = 1;
			Student tempstudent = session.get(Student.class, theId);
			
			System.out.println("\n\n\n==========Loaded the student===========\n\n\n" +tempstudent);
			System.out.println("\n\n\n==========Courses of the student===========\n\n\n" +tempstudent.getCourses());
			//create more courses
			System.out.println("\\n\\n\\n==========Deleting the student===========\\n\\n\\n");
			session.delete(tempstudent);
			
			
			//Commit
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			
			session.close();
			factory.close();
		}
		

	}

}
