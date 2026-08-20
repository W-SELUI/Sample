import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BuiltInSort {

    public static void sort(List<University> list,
                            Comparator<University> comparator) {

        Collections.sort(list, comparator);
    }
}