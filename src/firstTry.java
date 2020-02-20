import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class firstTry {
	public static ArrayList<Library> calcLibraries10495004(Book[] books, Library[] libs, long days) {
		ArrayList<Library> sendingLibs = new ArrayList<>();
		for(int iL = 0, cntL = libs.length; iL < cntL && days >= 0; iL++) {
			Library l = libs[iL];
			if (l.qBooks > 0) {
				days -= l.signUpTime;
				if (days > 0) {
					sendingLibs.add(l);
					l.books.sort((o1, o2) -> o1.value - o2.value);
					BigInteger maxBooks = BigInteger.valueOf(days).multiply(BigInteger.valueOf(l.qBooksPerDay));
					for (long iB = 0; iB < maxBooks.longValue() && iB < l.qBooks; iB++) {
						l.sendBook(l.books.get((int)iB));					
					}
				}
			}
		}
		
		return sendingLibs;
	}

	public static ArrayList<Library> calcLibraries2(Book[] books, Library[] libs, long days) {
		ArrayList<Library> sendingLibs = new ArrayList<>();
		List<Library> allLibs = (List<Library>) Arrays.asList(libs);
		allLibs.sort(new SortByWeight());
		for(int iL = 0, cntL = allLibs.size(); iL < cntL && days >= 0; iL++) {
			Library l = allLibs.get(iL);
			if (l.qBooks > 0) {
				days -= l.signUpTime;
				if (days > 0) {
					sendingLibs.add(l);
					l.books.sort((o1, o2) -> o2.value - o1.value); // descending
					for (long iB = 0; iB < l.qBooks; iB++) {
						for (long iBpD = 0; iBpD < l.qBooksPerDay && iB < l.qBooks; iBpD++) {
							l.sendBook(l.books.get((int)iB));
							iB++;
						}
					}
				}
			}
		}
		
		return sendingLibs;
	}
	
	public static ArrayList<Library> calcLibraries3(Book[] books, Library[] libs, int days) {
		ArrayList<Library> sendingLibs = new ArrayList<>();
		ArrayList<Library> remainingLibs = new ArrayList<>(Arrays.asList(libs));
		for(Library l : remainingLibs)
			l.sortBooks();
		for(int iL = 0, cntL = remainingLibs.size(); iL < cntL && days >= 0; iL++) {
			for(Library l : remainingLibs)
				l.calcPossibleScoreAndBooksToSend(days);
			remainingLibs.sort((o1, o2) -> Long.compare(o2.tmpPossibleScore, o1.tmpPossibleScore)); // descending
			Library l = remainingLibs.get(0);
			if (l.qBooks > 0) {
				days -= l.signUpTime;
				if (days > 0) {
					sendingLibs.add(l);
					remainingLibs.remove(0);
				}
			}
		}	
		return sendingLibs;
	}
	
	 static ArrayList<Library> calcLibraries4(Book[] books, Library[] libs, int days) {
		ArrayList<Library> sendingLibs = new ArrayList<>();
		ArrayList<Library> remainingLibs = new ArrayList<>(Arrays.asList(libs));
		ArrayList<Book> alreadySentBooks = new ArrayList<>();
		for(Library l : remainingLibs)
			l.sortBooks();
		for(int iL = 0, cntL = remainingLibs.size(); iL < cntL && days >= 0; iL++) {
			for(Library l : remainingLibs)
				l.calcPossibleScoreAndBooksToSend(days);
			remainingLibs.sort((o1, o2) -> Long.compare(o2.tmpPossibleScore, o1.tmpPossibleScore)); // descending
			Library l = remainingLibs.get(0);
			if (l.qBooks > 0) {
				days -= l.signUpTime;
				if (days > 0) {
					sendingLibs.add(l);
					remainingLibs.remove(0);
				}
			}
		}	
		return sendingLibs;
	}
	 
}
