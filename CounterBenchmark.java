import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CounterBenchmark {

    public static BenchmarkStatistics measureInsertionOperations(
            List<University> original) {

        List<Long> operations = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            List<University> copy =
                    new ArrayList<>(original);

            Collections.shuffle(copy);

            SortMetrics metrics =
                    new SortMetrics();

            InsertionSort.sort(
                    copy,
                    new NameComparator(),
                    metrics);

            operations.add(
                    metrics.getTotalOperations());
        }

        return calculateStatistics(
                operations);
    }

    public static BenchmarkStatistics measureBubbleOperations(
            List<University> original) {

        List<Long> operations = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            List<University> copy =
                    new ArrayList<>(original);

            Collections.shuffle(copy);

            SortMetrics metrics =
                    new SortMetrics();

            BubbleSort.sort(
                    copy,
                    new NameComparator(),
                    metrics);

            operations.add(
                    metrics.getTotalOperations());
        }

        return calculateStatistics(
                operations);
    }

    public static BenchmarkStatistics measureMergeOperations(
            List<University> original) {

        List<Long> operations = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            List<University> copy =
                    new ArrayList<>(original);

            Collections.shuffle(copy);

            SortMetrics metrics =
                    new SortMetrics();

            MergeSort.sort(
                    copy,
                    new NameComparator(),
                    metrics);

            operations.add(
                    metrics.getTotalOperations());
        }

        return calculateStatistics(
                operations);
    }

    private static BenchmarkStatistics calculateStatistics(
            List<Long> values) {

        Collections.sort(values);

        long best = values.get(0);

        long worst =
                values.get(values.size() - 1);

        long total = 0;

        for (long value : values) {
            total += value;
        }

        long mean =
                total / values.size();

        int middle =
                values.size() / 2;

        long median;

        if (values.size() % 2 == 0) {

            median =
                    (values.get(middle - 1)
                    + values.get(middle)) / 2;

        } else {

            median =
                    values.get(middle);
        }

        return new BenchmarkStatistics(
                best,
                mean,
                median,
                worst);
    }
}