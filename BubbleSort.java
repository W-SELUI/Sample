import java.util.Comparator;
import java.util.List;

public class BubbleSort {

    public static void sort(List<University> list,
                            Comparator<University> comparator) {

        int n = list.size();

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (comparator.compare(
                        list.get(j),
                        list.get(j + 1)) > 0) {

                    University temp = list.get(j);

                    list.set(j, list.get(j + 1));

                    list.set(j + 1, temp);

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}