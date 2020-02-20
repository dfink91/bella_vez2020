import java.util.*; 


class SortByShipping implements Comparator<Library> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Library a, Library b) 
    { 
        return b.qBooksPerDay - a.qBooksPerDay; 
    } 
} 