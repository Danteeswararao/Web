package hibernet.com.sample;


public class Book {

	private int id;
	private String title;
	private String author;
	private int price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, int price) {
		//super();
		//this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
