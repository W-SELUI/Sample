import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Benchmark {

    public static BenchmarkStatistics measureInsertionSort(
            List<University> original,
            Comparator<University> comparator) {

        List<Long> times = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            List<University> copy =
                    new ArrayList<>(original);

            Collections.shuffle(copy);

            long start = System.nanoTime();

            InsertionSort.sort(copy, comparator);

            long end = System.nanoTime();

            times.add(end - start);
        }

        return calculateStatistics(times);
    }

    public static BenchmarkStatistics measureBubbleSort(
            List<University> original,
            Comparator<University> comparator) {

        List<Long> times = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            List<University> copy =
                    new ArrayList<>(original);

            Collections.shuffle(copy);

            long start = System.nanoTime();

            BubbleSort.sort(copy, comparator);

            long end = System.nanoTime();

            times.add(end - start);
        }

        return calculateStatistics(times);
    }

    public static BenchmarkStatistics measureMergeSort(
            List<University> original,
            Comparator<University> comparator) {

        List<Long> times = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            List<University> copy =
                    new ArrayList<>(original);

            Collections.shuffle(copy);

            long start = System.nanoTime();

            MergeSort.sort(copy, comparator);

            long end = System.nanoTime();

            times.add(end - start);
        }

        return calculateStatistics(times);
    }

    public static BenchmarkStatistics measureBuiltInSort(
            List<University> original,
            Comparator<University> comparator) {

        List<Long> times = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            List<University> copy =
                    new ArrayList<>(original);

            Collections.shuffle(copy);

            long start = System.nanoTime();

            BuiltInSort.sort(copy, comparator);

            long end = System.nanoTime();

            times.add(end - start);
        }

        return calculateStatistics(times);
    }

    private static BenchmarkStatistics calculateStatistics(
            List<Long> times) {

        Collections.sort(times);

        long best = times.get(0);

        long worst = times.get(times.size() - 1);

        long total = 0;

        for (long time : times) {
            total += time;
        }

        long mean = total / times.size();

        long median;

        int middle = times.size() / 2;

        if (times.size() % 2 == 0) {

            median =
                    (times.get(middle - 1)
                    + times.get(middle)) / 2;

        } else {

            median = times.get(middle);
        }

        return new BenchmarkStatistics(
                best,
                mean,
                median,
                worst);
    }
}