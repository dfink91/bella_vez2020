import java.util.*;

class SortByRegistration implements Comparator<Library> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(Library a, Library b) {
        if (a.signUpTime > b.signUpTime)
            return 1;
        if (a.signUpTime < b.signUpTime)
            return -1;

        return 0;
    }
}