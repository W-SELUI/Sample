import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CounterStatisticsExporter {

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
                            "CounterStatistics.csv");

            writer.write(
                    "Size,Algorithm,Best,Mean,Median,Worst\n");

            for (int size : sizes) {

                List<University> subset =
                        DatasetUtils.getSubset(
                                universities,
                                size);

                writeStatistics(
                        writer,
                        size,
                        "Insertion",
                        CounterBenchmark
                                .measureInsertionOperations(
                                        subset));

                writeStatistics(
                        writer,
                        size,
                        "Bubble",
                        CounterBenchmark
                                .measureBubbleOperations(
                                        subset));

                writeStatistics(
                        writer,
                        size,
                        "Merge",
                        CounterBenchmark
                                .measureMergeOperations(
                                        subset));
            }

            writer.close();

            System.out.println(
                    "Counter statistics exported to CounterStatistics.csv");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void writeStatistics(
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