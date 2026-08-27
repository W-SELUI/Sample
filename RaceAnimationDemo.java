import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RaceAnimationDemo {

    public static void main(String[] args) {

        RaceGUI gui =
                new RaceGUI();

        gui.getStartButton()
                .addActionListener(e -> {

                    new Thread(() -> {

                        gui.disableStartButton();

                        gui.showCountdown();

                        gui.clearResults();

                        try {

                            List<University> universities =
                                    CSVReader.loadUniversities(
                                            "World University Rankings 2023-Cleaned.csv");

                            Comparator<University> comparator;

                            String selection =
                                    gui.getSelectedComparator();

                            switch (selection) {

                                case "Rank":
                                    comparator =
                                            new RankComparator();
                                    break;

                                case "Score":
                                    comparator =
                                            new ScoreComparator();
                                    break;

                                case "Location":
                                    comparator =
                                            new LocationComparator();
                                    break;

                                default:
                                    comparator =
                                            new NameComparator();
                            }

                            SortRaceThread insertion =
                                    new SortRaceThread(
                                            "Insertion",
                                            universities,
                                            comparator);

                            SortRaceThread bubble =
                                    new SortRaceThread(
                                            "Bubble",
                                            universities,
                                            comparator);

                            SortRaceThread merge =
                                    new SortRaceThread(
                                            "Merge",
                                            universities,
                                            comparator);

                            SortRaceThread builtIn =
                                    new SortRaceThread(
                                            "BuiltIn",
                                            universities,
                                            comparator);

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

                            gui.animateRace(
                                builtIn.getExecutionTime(),
                                merge.getExecutionTime(),
                                insertion.getExecutionTime(),
                                bubble.getExecutionTime(),
                                gui.getAnimationDelay());

                            Thread.sleep(4500);

                            gui.appendResult(
                                    "Sorted By: "
                                            + selection);

                            gui.appendResult("");

                            gui.appendResult(
                                    "FINAL STANDINGS");

                            gui.appendResult("");

                            gui.appendResult(
                                    "1st: "
                                            + results.get(0).getAlgorithmName()
                                            + " - "
                                            + results.get(0).getExecutionTime()
                                            + " ns");

                            gui.appendResult(
                                    "2nd: "
                                            + results.get(1).getAlgorithmName()
                                            + " - "
                                            + results.get(1).getExecutionTime()
                                            + " ns");

                            gui.appendResult(
                                    "3rd: "
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
                                    "Winner: "
                                            + results.get(0).getAlgorithmName());

                            gui.enableStartButton();

                        } catch (InterruptedException ex) {

                            ex.printStackTrace();

                            gui.enableStartButton();
                        }

                    }).start();
                });

        gui.getResetButton()
                .addActionListener(e -> {

                    gui.resetRace();
                });
    }
}