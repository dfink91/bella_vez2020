import java.util.ArrayList;
import java.util.Collections;

public class SecondTry {
	public static ArrayList<Library> calcLibraries(Book[] books, Library[] libs, int days) {
		ArrayList<Library> sendingLibs = new ArrayList<>();
		Collections.sort(sendingLibs, new SortByRegistration());
		for (int iL = 0, cntL = libs.length; iL < cntL && days >= 0; iL++) {
			Library l = libs[iL];
			days -= l.signUpTime;
			System.out.println("time remaining: " + days);
			if (days > 0 && l.qBooks > 0) {
				sendingLibs.add(l);
				long maxBooks = days * l.qBooksPerDay;
				for (int iB = 0; iB < maxBooks && iB < l.qBooks; iB++) {
					l.sendBook(l.books.get(iB));
				}
			}
		}

		return sendingLibs;
	}
}
