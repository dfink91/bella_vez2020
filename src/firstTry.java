import java.math.BigInteger;
import java.util.ArrayList;

public class firstTry {
	public static ArrayList<Library> calcLibraries(Book[] books, Library[] libs, long days) {
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
}
