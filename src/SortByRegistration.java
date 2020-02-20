import java.util.*; 


class SortByRegistration implements Comparator<Library> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Library a, Library b) 
    { 
        return a.signUpTime - b.signUpTime; 
    } 
} 