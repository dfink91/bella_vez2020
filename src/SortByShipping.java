import java.util.*;

class SortByShipping implements Comparator<Library> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Library a, Library b) {
        if (b.qBooksPerDay > a.qBooksPerDay)
            return 1;
        if (b.qBooksPerDay < a.qBooksPerDay)
            return -1;
        return 0;
    }
}