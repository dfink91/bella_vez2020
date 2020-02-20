
public class Library {

	public int qBooks, signUpTime, qBooksPerDay;
	
	public Book[] books;
	
	public Library(int qBooks, int signUpTime, int qBooksPerDay) {
		this.qBooks = qBooks;
		this.signUpTime = signUpTime;
		this.qBooksPerDay = qBooksPerDay;
		books = new Book[qBooks];
	}
	
	public void addBook(Book b) {
		books[b.idx] = b;
	}
	
}
