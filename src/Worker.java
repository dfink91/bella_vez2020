import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Worker {


	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.run();
	}
	
    public void run() {
		System.out.println("I'm the workermain.");
		System.out.println(System.getProperty("user.dir"));
		String[] files = new String[6];
		files[0] = "a_example";
		files[1] = "b_read_on";
		files[2] = "c_incunabula";
		files[3] = "d_tough_choices";
		files[4] = "e_so_many_books";
		files[5] = "f_libraries_of_the_world";
		int counter = 0;
		while (counter < files.length) {
			String file = files[counter];
			if (file != null) {
				try (FileReader fr = new FileReader("in" + File.separator + file + ".txt");
					 BufferedReader br = new BufferedReader(fr);
					 FileWriter fw = new FileWriter("out" + File.separator + file + ".txt");
					 BufferedWriter bw = new BufferedWriter(fw);
					 PrintWriter pw = new PrintWriter(bw);) 
				{
					System.out.println("Parsing file: " + file);
					String[] bits = br.readLine().split(" ");
					int qB = Integer.parseInt(bits[0]);
					int qL = Integer.parseInt(bits[1]);
					int days = Integer.parseInt(bits[2]);
					System.out.print(qB + " books; ");
					System.out.print(qL + " libraries; ");
					System.out.print(days + " days");
					
					Book[] books = new Book[qB];
					Library[] libs = new Library[qL];
					
					
					// Read all books
					bits = br.readLine().split(" ");
					for(int i = 0; i < qB; i++) {
						books[i] = new Book(i, Integer.parseInt(bits[i])); 
					}
					
					// Read libraries
					for(int i = 0; i < qL; i++) {
						bits = br.readLine().split(" ");
						int qbpl = Integer.parseInt(bits[0]);
						libs[i] = new Library(qbpl, Integer.parseInt(bits[1]), Integer.parseInt(bits[2]));
						libs[i].idx = i;
						bits = br.readLine().split(" ");
						for(int j = 0; j < qbpl; j++) {
							libs[i].addBook(books[Integer.parseInt(bits[j])]);
						}
					}
					

//					ArrayList<Library> sendingLibs = firstTry.calcLibraries10495004(books, libs, days);
					
					ArrayList<Library> sendingLibs = firstTry.calcLibraries2(books, libs, days);
					
//					ArrayList<Library> sendingLibs = SecondTry.calcLibraries(books, libs, days);
															
					int cnt = sendingLibs.size();
					pw.println(cnt);
					for(int i = 0; i < cnt; i++) {
						Library l = sendingLibs.get(i);
						int sizeSentBooks = l.sentBooks.size();
						pw.println(l.idx + " " + sizeSentBooks);
						for(int j = 0; j < sizeSentBooks; j++) {
							pw.print(l.sentBooks.get(j).idx + (j + 1 < sizeSentBooks ? " " : ""));
						}
						pw.println();
					}
					
					System.out.println();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			counter++;
			//break;	
		}
		System.out.println("The end.");
    }

}
