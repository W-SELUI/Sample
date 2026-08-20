import java.util.Comparator;
import java.util.List;

public class InsertionSort {

    public static void sort(List<University> list,
                            Comparator<University> comparator) {

        for (int i = 1; i < list.size(); i++) {

            University current = list.get(i);

            int j = i - 1;

            while (j >= 0 &&
                   comparator.compare(list.get(j), current) > 0) {

                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, current);
        }
    }
}