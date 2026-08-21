import java.util.Comparator;
import java.util.List;

public class InsertionSort {

    public static void sort(
            List<University> list,
            Comparator<University> comparator) {

        sort(
                list,
                comparator,
                new SortMetrics());
    }

    public static void sort(
            List<University> list,
            Comparator<University> comparator,
            SortMetrics metrics) {

        for (int i = 1; i < list.size(); i++) {

            University current = list.get(i);

            metrics.incrementMoves();

            int j = i - 1;

            while (j >= 0) {

                metrics.incrementComparisons();

                if (comparator.compare(
                        list.get(j),
                        current) > 0) {

                    list.set(j + 1,
                            list.get(j));

                    metrics.incrementMoves();

                    j--;

                } else {

                    break;
                }
            }

            list.set(j + 1, current);

            metrics.incrementMoves();
        }
    }
}