import java.util.ArrayList;

public class firstTry {
	public static ArrayList<Library> calcLibraries(Book[] books, Library[] libs, int days) {
		ArrayList<Library> sendingLibs = new ArrayList<>();
		for(int iL = 0, cntL = libs.length; iL < cntL && days >= 0; iL++) {
			Library l = libs[iL];
			days -= l.signUpTime;
			System.out.println("time remaining: " + days);
			if (days > 0) {
				sendingLibs.add(l);
				l.sendBook(l.books.get(0));
			}
		}
		
		return sendingLibs;
	}
}
