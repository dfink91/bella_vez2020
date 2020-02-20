
public class Library {

	public int qBooks, signUpTime, qBooksPerDay;
	
	public Book[] books;
	
	public Library(int qBooks, int signUpTime, int qBooksPerDay) {
		this.qBooks = qBooks;
		this.signUpTime = signUpTime;
		this.qBooksPerDay = qBooksPerDay;
		books = new Book[qBooks];
	}
	public int calcBookWeight(){
		int score = 0;
		if(books == null){
			return 0;
		}
		for(int i = 0; i < books.length; i++){
			score += books[i].value;
		}
		return score;
	}
	
	public void addBook(Book b) {
		books[b.idx] = b;
	}
	
}
