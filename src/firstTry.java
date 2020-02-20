import java.util.ArrayList;

public class firstTry {
	public static ArrayList<Library> calcLibraries(Book[] books, Library[] libs, int days) {
		ArrayList<Library> sendingLibs = new ArrayList<>();
//		for(int iL = 0, cntL = libs.length; iL < cntL; iL++) {
		Library l = libs[0];
		sendingLibs.add(libs[0]);
		l.sendBook(l.books.get(0));
//		}
		
		return sendingLibs;
	}
}
