import java.util.*; 
import java.lang.*; 
import java.io.*; 

class SortByWeight implements Comparator<Library> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Library a, Library b) 
    { 
        return b.calcBookWeight() - a.calcBookWeight(); 
    } 
} 