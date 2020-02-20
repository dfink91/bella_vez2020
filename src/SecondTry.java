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
				l.books.sort((o1, o2) -> o2.value - o1.value); // descending
				for (long iB = 0; iB < l.qBooks; iB++) {
					for (long iBpD = 0; iBpD < l.qBooksPerDay && iB < l.qBooks; iBpD++) {
						l.sendBook(l.books.get((int)iB));
						iB++;
					}
				}
			}

		}

		return sendingLibs;
	}
}
