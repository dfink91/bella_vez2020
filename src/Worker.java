import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Worker {


	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.run();
	}
	
    public void run() {
		System.out.println("I'm the workermain.");
		System.out.println(System.getProperty("user.dir"));
		String[] files = new String[]{"a_example", "b_should_be_easy", "c_no_hurry", "d_metropolis", "e_high_bonus"};
		int counter = 0;
		while (counter < files.length) {
			String file = files[counter];
			try (FileReader fr = new FileReader("in" + File.separator + file + ".in");
				 BufferedReader br = new BufferedReader(fr);
				 FileWriter fw = new FileWriter("out" + File.separator + file + ".txt");
				 BufferedWriter bw = new BufferedWriter(fw);
				 PrintWriter pw = new PrintWriter(bw);) 
			{
				System.out.println("Parsing file: " + file);
				String[] bits = br.readLine().split(" ");
				for (String bit : bits) {
					System.out.print(bit + " ");
				}
				System.out.println();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			counter++;
			//break;	
		}
		System.out.println("The end.");
    }

}
