import java.util.List;

public class RaceDemo {

    public static void main(String[] args)
            throws InterruptedException {

        List<University> universities =
                CSVReader.loadUniversities(
                        "World University Rankings 2023-Cleaned.csv");

        System.out.println("Race starts in...");

        for (int i = 3; i >= 1; i--) {

            System.out.println(i);

            Thread.sleep(1000);
        }

        System.out.println("GO!\n");

        SortRaceThread insertion =
                new SortRaceThread(
                        "Insertion",
                        universities,
                        new NameComparator());

        SortRaceThread bubble =
                new SortRaceThread(
                        "Bubble",
                        universities,
                        new NameComparator());

        SortRaceThread merge =
                new SortRaceThread(
                        "Merge",
                        universities,
                        new NameComparator());

        SortRaceThread builtIn =
                new SortRaceThread(
                        "BuiltIn",
                        universities,
                        new NameComparator());

        insertion.start();
        bubble.start();
        merge.start();
        builtIn.start();

        insertion.join();
        bubble.join();
        merge.join();
        builtIn.join();

        SortRaceThread winner = insertion;

        if (bubble.getExecutionTime()
                < winner.getExecutionTime()) {
            winner = bubble;
        }

        if (merge.getExecutionTime()
                < winner.getExecutionTime()) {
            winner = merge;
        }

        if (builtIn.getExecutionTime()
                < winner.getExecutionTime()) {
            winner = builtIn;
        }

        System.out.println(
                "\nWinner: "
                + winner.getAlgorithmName());
    }
}