package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Review;
import com.love2code.hibernate.demo.entity.Student;


public class DeleteCourseDemo {

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

			int courseId = 10;
			
			Course tempCourse = session.get(Course.class, courseId);
			
			System.out.println("=================>Deleting the course<================= ");
			session.delete(tempCourse);
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			
			session.close();
			factory.close();
		}
		

	}

}
