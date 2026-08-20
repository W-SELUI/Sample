import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortRaceThread extends Thread {

    private String algorithmName;
    private List<University> data;
    private Comparator<University> comparator;

    private long executionTime;

    public SortRaceThread(
            String algorithmName,
            List<University> data,
            Comparator<University> comparator) {

        this.algorithmName = algorithmName;
        this.data = new ArrayList<>(data);
        this.comparator = comparator;
    }

    @Override
    public void run() {

        System.out.println(
                algorithmName + " started...");

        long start = System.nanoTime();

        switch (algorithmName) {

            case "Insertion":
                InsertionSort.sort(data, comparator);
                break;

            case "Bubble":
                BubbleSort.sort(data, comparator);
                break;

            case "Merge":
                MergeSort.sort(data, comparator);
                break;

            case "BuiltIn":
                BuiltInSort.sort(data, comparator);
                break;
        }

        long end = System.nanoTime();

        executionTime = end - start;

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
                algorithmName
                + " finished in "
                + executionTime
                + " ns");
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }
}