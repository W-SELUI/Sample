import javax.swing.*;
import java.awt.*;

public class RaceGUI extends JFrame {

    private JProgressBar builtInBar;
    private JProgressBar mergeBar;
    private JProgressBar insertionBar;
    private JProgressBar bubbleBar;

    private JTextArea resultsArea;

    private JButton startButton;

    public RaceGUI() {

        setTitle("Algorithm Race");

        setSize(900, 600);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel racePanel =
                new JPanel(
                        new GridLayout(4, 1));

        builtInBar =
                new JProgressBar(0, 100);

        mergeBar =
                new JProgressBar(0, 100);

        insertionBar =
                new JProgressBar(0, 100);

        bubbleBar =
                new JProgressBar(0, 100);

        builtInBar.setStringPainted(true);
        mergeBar.setStringPainted(true);
        insertionBar.setStringPainted(true);
        bubbleBar.setStringPainted(true);

        racePanel.add(
                createLane(
                        "Built-In Sort",
                        builtInBar));

        racePanel.add(
                createLane(
                        "Merge Sort",
                        mergeBar));

        racePanel.add(
                createLane(
                        "Insertion Sort",
                        insertionBar));

        racePanel.add(
                createLane(
                        "Bubble Sort",
                        bubbleBar));

        add(
                racePanel,
                BorderLayout.NORTH);

        resultsArea =
                new JTextArea();

        resultsArea.setEditable(false);

        add(
                new JScrollPane(resultsArea),
                BorderLayout.CENTER);

        startButton =
                new JButton(
                        "START RACE");

        add(
                startButton,
                BorderLayout.SOUTH);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    private JPanel createLane(
            String label,
            JProgressBar bar) {

        JPanel panel =
                new JPanel(
                        new BorderLayout());

        panel.add(
                new JLabel(label),
                BorderLayout.WEST);

        panel.add(
                bar,
                BorderLayout.CENTER);

        return panel;
    }

    public JButton getStartButton() {

        return startButton;
    }

    public void clearResults() {

        resultsArea.setText("");

        builtInBar.setValue(0);
        mergeBar.setValue(0);
        insertionBar.setValue(0);
        bubbleBar.setValue(0);
    }

    public void appendResult(
            String text) {

        resultsArea.append(
                text + "\n");
    }

    public JProgressBar getBuiltInBar() {

        return builtInBar;
    }

    public JProgressBar getMergeBar() {

        return mergeBar;
    }

    public JProgressBar getInsertionBar() {

        return insertionBar;
    }

    public JProgressBar getBubbleBar() {

        return bubbleBar;
    }

    public void animateRace(
        long builtInTime,
        long mergeTime,
        long insertionTime,
        long bubbleTime) {

                long maxTime =
                        Math.max(
                                Math.max(builtInTime, mergeTime),
                                Math.max(insertionTime, bubbleTime));

                new Thread(() -> {

                        for (int i = 0; i <= 100; i++) {

                        final int progress = i;

                        SwingUtilities.invokeLater(() -> {

                                builtInBar.setValue(
                                        (int) (progress
                                                * ((double) maxTime
                                                / builtInTime)));

                                mergeBar.setValue(
                                        (int) (progress
                                                * ((double) maxTime
                                                / mergeTime)));

                                insertionBar.setValue(
                                        (int) (progress
                                                * ((double) maxTime
                                                / insertionTime)));

                                bubbleBar.setValue(
                                        progress);

                                if (builtInBar.getValue() > 100) {
                                builtInBar.setValue(100);
                                }

                                if (mergeBar.getValue() > 100) {
                                mergeBar.setValue(100);
                                }

                                if (insertionBar.getValue() > 100) {
                                insertionBar.setValue(100);
                                }
                        });

                        try {

                                Thread.sleep(40);

                        } catch (InterruptedException e) {

                                e.printStackTrace();
                        }
                        }

                }).start();
        }
}