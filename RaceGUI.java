import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RaceGUI extends JFrame {

    private JProgressBar builtInBar;
    private JProgressBar mergeBar;
    private JProgressBar insertionBar;
    private JProgressBar bubbleBar;

    private JTextArea resultsArea;

    private JButton startButton;
    private JButton resetButton;

    private JComboBox<String> comparatorBox;

    public RaceGUI() {

        setTitle(" Algorithm Grand Prix");

        setSize(1000, 650);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(245, 245, 245));

        JLabel titleLabel =
                new JLabel(
                        " ALGORITHM GRAND PRIX ",
                        SwingConstants.CENTER);

        titleLabel.setForeground(
                Color.BLACK);

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26));

        titleLabel.setBorder(
                new EmptyBorder(
                        10,
                        10,
                        10,
                        10));

        add(
                titleLabel,
                BorderLayout.NORTH);

        JPanel racePanel =
                new JPanel(
                        new GridLayout(
                                4,
                                1,
                                10,
                                10));

        racePanel.setBackground(
                Color.WHITE);

        racePanel.setBorder(
                new EmptyBorder(
                        10,
                        15,
                        10,
                        15));

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

        builtInBar.setString(
                "Built-In");

        mergeBar.setString(
                "Merge");

        insertionBar.setString(
                "Insertion");

        bubbleBar.setString(
                "Bubble");

        builtInBar.setForeground(
                new Color(
                        46,
                        204,
                        113));

        mergeBar.setForeground(
                new Color(
                        52,
                        152,
                        219));

        insertionBar.setForeground(
                new Color(
                        241,
                        196,
                        15));

        bubbleBar.setForeground(
                new Color(
                        231,
                        76,
                        60));

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
                BorderLayout.WEST);

        resultsArea =
                new JTextArea();

        resultsArea.setEditable(false);

        resultsArea.setBackground(
                Color.WHITE);

        resultsArea.setForeground(
                Color.BLACK);

        resultsArea.setFont(
                new Font(
                        "Consolas",
                        Font.PLAIN,
                        18));

        JScrollPane scrollPane =
                new JScrollPane(
                        resultsArea);

        add(
                scrollPane,
                BorderLayout.CENTER);

        startButton =
        new JButton(
                "🚦 START GRAND PRIX");

        resetButton =
        new JButton(
                "RESET");

        startButton.setBackground(
        new Color(
                46,
                204,
                113));

        startButton.setForeground(
                Color.WHITE);

        startButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20));

        String[] options = {
                "Name",
                "Rank",
                "Score",
                "Location"
        };

        comparatorBox =
                new JComboBox<>(
                        options);

        comparatorBox.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14));

        JPanel bottomPanel =
                new JPanel(
                        new BorderLayout());

        JPanel selectionPanel =
                new JPanel();

        selectionPanel.add(
                new JLabel(
                        "Sort By:"));

        selectionPanel.add(
                comparatorBox);

        bottomPanel.add(
                selectionPanel,
                BorderLayout.NORTH);

        JPanel buttonPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                10,
                                0));

        buttonPanel.add(
                startButton);

        buttonPanel.add(
                resetButton);

        bottomPanel.add(
                buttonPanel,
                BorderLayout.SOUTH);

        add(
                bottomPanel,
                BorderLayout.SOUTH);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    private JPanel createLane(
            String label,
            JProgressBar bar) {

        JPanel panel =
                new JPanel(
                        new BorderLayout(
                                10,
                                10));

        panel.setBackground(
                Color.WHITE);

        JLabel laneLabel =
                new JLabel(
                        label);

        laneLabel.setForeground(
                Color.BLACK);

        laneLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16));

        panel.add(
                laneLabel,
                BorderLayout.NORTH);

        panel.add(
                bar,
                BorderLayout.CENTER);

        return panel;
    }

    public JButton getStartButton() {

        return startButton;
    }

    public JButton getResetButton() {

         return resetButton;
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

    public void showCountdown() {

        try {

            for (int i = 3; i >= 1; i--) {

                resultsArea.setText(
                        " RACE STARTING IN...\n\n"
                                + i);

                Thread.sleep(1000);
            }

            resultsArea.setText(
                    " GO!");

            Thread.sleep(1000);

            resultsArea.setText("");

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

        public void animateRace(
                long builtInTime,
                long mergeTime,
                long insertionTime,
                long bubbleTime) {

        long maxTime =
                Math.max(
                        Math.max(
                                builtInTime,
                                mergeTime),
                        Math.max(
                                insertionTime,
                                bubbleTime));

        new Thread(() -> {

                for (int i = 0; i <= 100; i++) {

                final int progress = i;

                SwingUtilities.invokeLater(() -> {

                        builtInBar.setValue(
                                Math.min(
                                        100,
                                        (int) (progress
                                                * ((double) maxTime
                                                / builtInTime))));

                        mergeBar.setValue(
                                Math.min(
                                        100,
                                        (int) (progress
                                                * ((double) maxTime
                                                / mergeTime))));

                        insertionBar.setValue(
                                Math.min(
                                        100,
                                        (int) (progress
                                                * ((double) maxTime
                                                / insertionTime))));

                        bubbleBar.setValue(
                                Math.min(
                                        100,
                                        (int) (progress
                                                * ((double) maxTime
                                                / bubbleTime))));
                });

                try {

                        Thread.sleep(40);

                } catch (InterruptedException e) {

                        e.printStackTrace();
                }
                }

          }).start();
        }

        public String getSelectedComparator() {

                return (String)
                comparatorBox.getSelectedItem();
                }

                public void resetRace() {

        resultsArea.setText("");

        builtInBar.setValue(0);
        mergeBar.setValue(0);
        insertionBar.setValue(0);
        bubbleBar.setValue(0);
        }

        public void disableStartButton() {

        startButton.setEnabled(false);

        startButton.setText(
                "RACE IN PROGRESS...");
        }

        public void enableStartButton() {

        startButton.setEnabled(true);

        startButton.setText(
                "🚦 START GRAND PRIX");
        }
}