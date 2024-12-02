import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YearComparable {

    public static void main(String args[]) {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("Torzon",102L,2000));
        list.add(new Movie("Din Rat",103L,1999));
        list.add(new Movie("Aankhen",112L,2003));
        Collections.sort(list);
        for(Movie movie : list) {
            System.out.println(movie.name);
        }
    }
}
