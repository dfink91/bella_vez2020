package bellavez;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

public class PizzaSolution {

    public static int[] inputData = new int [2];
    public static int[] inputDataType;

    public static int[] resultData = new int [2];
    public static int[] resultDataType;

    public static void main(String args[]) {
        readFile();
        System.out.println(Arrays.toString(inputData));
        System.out.println(Arrays.toString(inputDataType));
        writeFile();
    }

    public static void readFile() {
    try {
      File myObj = new File("a.in"); // Input file name
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String [] str = data.split(" ");
        int size = str.length;
        int [] arr = new int [size];
        for(int i=0; i<size; i++) {
          arr[i] = Integer.parseInt(str[i]);
        }
        // System.out.println(Arrays.toString(arr));
        if (inputData[0] == 0) {
          inputData = arr;
        } else {
          inputDataType = arr;
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void writeFile() {
    try {
      FileWriter myWriter = new FileWriter("Solution.txt");
      myWriter.write(Arrays.toString(resultData) + "\n" + Arrays.toString(resultDataType));
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
