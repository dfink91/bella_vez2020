import java.util.ArrayList;

public class Library {

	public int idx;
	public int qBooks, signUpTime, qBooksPerDay;

	public ArrayList<Book> books;
	public ArrayList<Book> sentBooks;
	
	public Library(int qBooks, int signUpTime, int qBooksPerDay) {
		this.qBooks = qBooks;
		this.signUpTime = signUpTime;
		this.qBooksPerDay = qBooksPerDay;
		books = new ArrayList<>();
		sentBooks = new ArrayList<>();
	}
	
	public int calcBookWeight(){
		int score = 0;
		if(books == null){
			return 0;
		}
		for(int i = 0; i < books.size(); i++){
			score += books.get(i).value;
		}
		return score;
	}
	
	public void addBook(Book b) {
		books.add(b);
	}
	
	public void sendBook(Book b) {
		sentBooks.add(b);
	}
	
}
