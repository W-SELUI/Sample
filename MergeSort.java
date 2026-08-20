import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort {

    public static void sort(List<University> list,
                            Comparator<University> comparator) {

        if (list.size() <= 1) {
            return;
        }

        int mid = list.size() / 2;

        List<University> left =
                new ArrayList<>(list.subList(0, mid));

        List<University> right =
                new ArrayList<>(list.subList(mid, list.size()));

        sort(left, comparator);
        sort(right, comparator);

        merge(list, left, right, comparator);
    }

    private static void merge(List<University> list,
                              List<University> left,
                              List<University> right,
                              Comparator<University> comparator) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {

            if (comparator.compare(left.get(i), right.get(j)) <= 0) {

                list.set(k++, left.get(i++));
            } else {

                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {

            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {

            list.set(k++, right.get(j++));
        }
    }
}
