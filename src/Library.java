import java.util.ArrayList;

public class Library {

	public int idx;
	public int qBooks, signUpTime, qBooksPerDay;

	public Book[] books;
	public ArrayList<Book> sentBooks;
	
	public Library(int qBooks, int signUpTime, int qBooksPerDay) {
		this.qBooks = qBooks;
		this.signUpTime = signUpTime;
		this.qBooksPerDay = qBooksPerDay;
		books = new Book[qBooks];
		sentBooks = new ArrayList<>();
	}
		
	public void addBook(Book b) {
		books[b.idx] = b;
	}
	
}
