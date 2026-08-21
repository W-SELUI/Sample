import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceAnimationDemo {

    public static void main(String[] args) {

        RaceGUI gui =
                new RaceGUI();

        gui.getStartButton()
                .addActionListener(e -> {

                    gui.clearResults();

                    try {

                        List<University> universities =
                                CSVReader.loadUniversities(
                                        "World University Rankings 2023-Cleaned.csv");

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

                        List<RaceResult> results =
                                new ArrayList<>();

                        results.add(
                                new RaceResult(
                                        "Insertion",
                                        insertion.getExecutionTime()));

                        results.add(
                                new RaceResult(
                                        "Bubble",
                                        bubble.getExecutionTime()));

                        results.add(
                                new RaceResult(
                                        "Merge",
                                        merge.getExecutionTime()));

                        results.add(
                                new RaceResult(
                                        "BuiltIn",
                                        builtIn.getExecutionTime()));

                        Collections.sort(results);

                        gui.appendResult(
                                "🏁 FINAL STANDINGS");

                        gui.appendResult("");

                        gui.appendResult(
                                "🥇 1st: "
                                + results.get(0).getAlgorithmName()
                                + " - "
                                + results.get(0).getExecutionTime()
                                + " ns");

                        gui.appendResult(
                                "🥈 2nd: "
                                + results.get(1).getAlgorithmName()
                                + " - "
                                + results.get(1).getExecutionTime()
                                + " ns");

                        gui.appendResult(
                                "🥉 3rd: "
                                + results.get(2).getAlgorithmName()
                                + " - "
                                + results.get(2).getExecutionTime()
                                + " ns");

                        gui.appendResult(
                                "4th: "
                                + results.get(3).getAlgorithmName()
                                + " - "
                                + results.get(3).getExecutionTime()
                                + " ns");

                        gui.appendResult("");

                        gui.appendResult(
                                "🏆 Winner: "
                                + results.get(0).getAlgorithmName());

                    } catch (InterruptedException ex) {

                        ex.printStackTrace();
                    }
                });
    }
}