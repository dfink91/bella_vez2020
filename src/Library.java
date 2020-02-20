import java.util.ArrayList;

public class Library {

	public int idx;
	public long qBooks, signUpTime, qBooksPerDay, bookWeight;

	public ArrayList<Book> books;
	public ArrayList<Book> sentBooks;
	
	public long tmpPossibleScore;

	public Library(int qBooks, int signUpTime, int qBooksPerDay) {
		this.qBooks = qBooks;
		this.signUpTime = signUpTime;
		this.qBooksPerDay = qBooksPerDay;
		books = new ArrayList<Book>();
		bookWeight = -1;
		sentBooks = new ArrayList<>();
	}

	public long calcBookWeight() {
		if (bookWeight != -1) {
			return bookWeight;
		}
		int score = 0;
		if (books == null) {
			return 0;
		}
		for(int i = 0; i < books.size(); i++){
			score += books.get(i).value;
		}
		bookWeight = score;
		return score;
	}

	public void addBook(Book b) {
		books.add(b);
	}
	
	public void sendBook(Book b) {
		sentBooks.add(b);
	}

	public void sortBooks() {
		books.sort((o1, o2) -> o2.value - o1.value); // descending
	}
	
	public void calcPossibleScoreAndBooksToSend(int days) {
		tmpPossibleScore = 0;	
		sentBooks = new ArrayList<>();
		for (long iB = 0; iB < qBooks; iB++) {
			for (long iBpD = 0; iBpD < qBooksPerDay && iB < qBooks; iBpD++) {
				Book b = books.get((int)iB);
				sendBook(b);
				tmpPossibleScore += b.value;
				iB++;
			}
		}
	}
}
