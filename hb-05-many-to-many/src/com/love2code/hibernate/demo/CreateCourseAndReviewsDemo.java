package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Course;
import com.love2code.hibernate.demo.entity.Instructor;
import com.love2code.hibernate.demo.entity.InstructorDetail;
import com.love2code.hibernate.demo.entity.Review;
import com.love2code.hibernate.demo.entity.Student;


public class CreateCourseAndReviewsDemo {

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
			//create a course
			Course tempCourse = new Course("Pacman - How to Score 1 Million ");
			
			System.out.println("\n\n\n========Saving the course===========\n\n\n");
			session.save(tempCourse);
			System.out.println("\n\n\n========Saved the course===========\n\n\n");
			//commit the transaction
			
			Student tempStudent = new Student("Dantesh","Kumar","danteshkumar@gmail.com");
			Student tempStudent1 = new Student("Harshitha","Kalla","harshitha.balla@gmail.com");
			
			//add students to course
			tempCourse.addStudent(tempStudent);
			tempCourse.addStudent(tempStudent1);
			
			//savingthe student
			System.out.println("\n\n\n========Saving the Students===========\n\n\n");
			session.save(tempStudent);
			session.save(tempStudent1);
			System.out.println("\n\n\n========Saved the Students===========\n\n\n");
			
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		}
		finally {
			
			session.close();
			factory.close();
		}
		

	}

}
