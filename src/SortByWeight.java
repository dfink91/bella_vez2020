import java.util.*; 


class SortByWeight implements Comparator<Library> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Library a, Library b) 
    { 
        return (int)Math.signum(b.calcBookWeight() - a.calcBookWeight()); 
    } 
} 