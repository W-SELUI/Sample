import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StatisticsExporter {

    public static void exportStatistics(
            List<University> universities) {

        int[] sizes = {
                100,
                300,
                600,
                900,
                1200,
                1697
        };

        try {

            FileWriter writer =
                    new FileWriter(
                            "StatisticsResults.csv");

            writer.write(
                    "Size,Algorithm,Best,Mean,Median,Worst\n");

            for (int size : sizes) {

                List<University> subset =
                        DatasetUtils.getSubset(
                                universities,
                                size);

                writeAlgorithmStatistics(
                        writer,
                        size,
                        "Insertion",
                        Benchmark.measureInsertionSort(
                                subset,
                                new NameComparator()));

                writeAlgorithmStatistics(
                        writer,
                        size,
                        "Bubble",
                        Benchmark.measureBubbleSort(
                                subset,
                                new NameComparator()));

                writeAlgorithmStatistics(
                        writer,
                        size,
                        "Merge",
                        Benchmark.measureMergeSort(
                                subset,
                                new NameComparator()));

                writeAlgorithmStatistics(
                        writer,
                        size,
                        "BuiltIn",
                        Benchmark.measureBuiltInSort(
                                subset,
                                new NameComparator()));
            }

            writer.close();

            System.out.println(
                    "Statistics exported to StatisticsResults.csv");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void writeAlgorithmStatistics(
            FileWriter writer,
            int size,
            String algorithm,
            BenchmarkStatistics stats)
            throws IOException {

        writer.write(
                size + ","
                + algorithm + ","
                + stats.getBest() + ","
                + stats.getMean() + ","
                + stats.getMedian() + ","
                + stats.getWorst() + "\n");
    }
}