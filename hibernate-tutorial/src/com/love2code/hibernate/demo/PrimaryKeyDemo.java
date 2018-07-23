package com.love2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.love2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
					System.out.println("Creating the 3 students  .....");
					Student student1 = new Student("Harshitha","Kalla","harshitha.kalla@gmail.com");
					Student student2 = new Student("John","Cena","johncena@gmail.com");
					Student student3 = new Student("Dhoni","Mahendra","dhonimahendra@gmail.com");
					//Start transaction 
					session.beginTransaction();
					//Save transaction
					System.out.println("Saving the students ...!");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					//commit the transaction
					session.getTransaction().commit();
					System.out.println("Done");
					
				}
				finally {
					factory.close();
				}
	}

}
