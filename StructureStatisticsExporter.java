import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StructureStatisticsExporter {

    public static void exportStatistics(
            List<University> universities) {

        int size = 1697;

        try {

            FileWriter writer =
                    new FileWriter(
                            "StructureStatistics.csv");

            writer.write(
                    "Algorithm,ArrayListMean,LinkedListMean\n");

            ArrayList<University> arrayList =
                    DatasetUtils.getArrayList(
                            universities,
                            size);

            LinkedList<University> linkedList =
                    DatasetUtils.getLinkedList(
                            universities,
                            size);

            writer.write(
                    "Insertion,"
                    + Benchmark.measureInsertionSort(
                            arrayList,
                            new NameComparator()).getMean()
                    + ","
                    + Benchmark.measureInsertionSort(
                            linkedList,
                            new NameComparator()).getMean()
                    + "\n");

            writer.write(
                    "Bubble,"
                    + Benchmark.measureBubbleSort(
                            arrayList,
                            new NameComparator()).getMean()
                    + ","
                    + Benchmark.measureBubbleSort(
                            linkedList,
                            new NameComparator()).getMean()
                    + "\n");

            writer.write(
                    "Merge,"
                    + Benchmark.measureMergeSort(
                            arrayList,
                            new NameComparator()).getMean()
                    + ","
                    + Benchmark.measureMergeSort(
                            linkedList,
                            new NameComparator()).getMean()
                    + "\n");

            writer.write(
                    "BuiltIn,"
                    + Benchmark.measureBuiltInSort(
                            arrayList,
                            new NameComparator()).getMean()
                    + ","
                    + Benchmark.measureBuiltInSort(
                            linkedList,
                            new NameComparator()).getMean()
                    + "\n");

            writer.close();

            System.out.println(
                    "Structure statistics exported to StructureStatistics.csv");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}