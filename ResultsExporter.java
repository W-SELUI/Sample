import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ResultsExporter {

    public static void exportResults(
            List<University> universities) {

        int[] sizes = {100, 300, 600, 900, 1200, 1697};

        try {

            FileWriter writer =
                    new FileWriter("Results.csv");

            writer.write(
                    "Size,Structure,Insertion,Bubble,Merge,BuiltIn\n");

            for (int size : sizes) {

                ArrayList<University> arrayList =
                        DatasetUtils.getArrayList(
                                universities,
                                size);

                long insertion =
                        Benchmark.measureInsertionSort(
                                arrayList,
                                new NameComparator());

                long bubble =
                        Benchmark.measureBubbleSort(
                                arrayList,
                                new NameComparator());

                long merge =
                        Benchmark.measureMergeSort(
                                arrayList,
                                new NameComparator());

                long builtIn =
                        Benchmark.measureBuiltInSort(
                                arrayList,
                                new NameComparator());

                writer.write(
                        size + ",ArrayList,"
                        + insertion + ","
                        + bubble + ","
                        + merge + ","
                        + builtIn + "\n");

                LinkedList<University> linkedList =
                        DatasetUtils.getLinkedList(
                                universities,
                                size);

                insertion =
                        Benchmark.measureInsertionSort(
                                linkedList,
                                new NameComparator());

                bubble =
                        Benchmark.measureBubbleSort(
                                linkedList,
                                new NameComparator());

                merge =
                        Benchmark.measureMergeSort(
                                linkedList,
                                new NameComparator());

                builtIn =
                        Benchmark.measureBuiltInSort(
                                linkedList,
                                new NameComparator());

                writer.write(
                        size + ",LinkedList,"
                        + insertion + ","
                        + bubble + ","
                        + merge + ","
                        + builtIn + "\n");
            }

            writer.close();

            System.out.println(
                    "Results exported to Results.csv");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}