import java.util.ArrayList;

public class Library {

	public int idx;
	public int qBooks, signUpTime, qBooksPerDay, bookWeight;

	public Book[] books;
	public ArrayList<Book> sentBooks;

	public Library(int qBooks, int signUpTime, int qBooksPerDay) {
		this.qBooks = qBooks;
		this.signUpTime = signUpTime;
		this.qBooksPerDay = qBooksPerDay;
		books = new Book[qBooks];
		bookWeight = -1;
		sentBooks = new ArrayList<>();
	}

	public int calcBookWeight() {
		if (bookWeight != -1) {
			return bookWeight;
		}
		int score = 0;
		if (books == null) {
			return 0;
		}
		for (int i = 0; i < books.length; i++) {
			score += books[i].value;
		}
		bookWeight = score;
		return score;
	}

	public void addBook(Book b) {
		books[b.idx] = b;
	}

}
