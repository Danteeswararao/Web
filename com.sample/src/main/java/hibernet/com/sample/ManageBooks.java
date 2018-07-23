package hibernet.com.sample;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.mapping.List;

public class ManageBooks {
	
	
	private static SessionFactory factory;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
				Configuration configure=new Configuration();  
	            configure.configure("hibernate.cfg.xml");
	            factory = configure.buildSessionFactory();
			//factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		}catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
		}
		
		ManageBooks mb = new ManageBooks();
		
		Integer bookId1 = mb.addBooks("Java","ABC",100);
		Integer bookId2 = mb.addBooks("Devops","XYZ",200);
		Integer bookId3 = mb.addBooks("Python","PQR",100);
		Integer bookId4 = mb.addBooks("Hibernate","MNO",100);
		
		
		mb.listBooks();
		mb.updateBook(bookId3,150);
		mb.deleteBook(bookId1);
		mb.updateBook(bookId2, 250);
		mb.listBooks();
		

	}
	public Integer addBooks(String title, String author, int price) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tnx = null;
		Integer bookId = null;
		
		try {
			tnx = session.beginTransaction();
			Book book = new Book(title,author,price);
			bookId = (Integer) session.save(book);
			tnx.commit();
		} catch (HibernateException e) {
	         if (tnx!=null) tnx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return bookId;
	}


	public void deleteBook(Integer bookId) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tnx = null;
		try {
			
			tnx = session.beginTransaction();
			Book book = (Book) session.get(Book.class, bookId);
			session.delete(book);
			tnx.commit();
			
		} catch (HibernateException e) {
			if (tnx!=null) tnx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }	
		
	}
	public void updateBook(Integer bookId, int price) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tnx = null;
		try {
			tnx = session.beginTransaction();
			Book book = (Book) session.get(Book.class,bookId);
			book.setPrice(price);
			session.update(book);
			tnx.commit();
			
		} catch (HibernateException e) {
			if (tnx!=null) tnx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }	
	}
	@SuppressWarnings("unchecked")
	public void listBooks() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Transaction tnx =null;
		try {
			tnx = session.beginTransaction();
			List<Book> books;
			books = session.createQuery("FROM BOOK").list();
			for (Iterator<Book> iterator = books.iterator();iterator.hasNext();)
			{
				Book book = (Book) iterator.next();
				System.out.println("Title of the book : " + book.getTitle());
				System.out.println("Author of the book : "+ book.getAuthor());
				System.out.println("Price of the book : " + book.getPrice());
			}
			tnx.commit();
			
		} catch (HibernateException e) {
        if (tnx!=null) tnx.rollback();
        e.printStackTrace(); 
     } finally {
        session.close(); 
     }
	}		
	
}
