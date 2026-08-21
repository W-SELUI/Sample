import javax.swing.*;
import java.awt.*;

public class RaceGUI extends JFrame {

    private JTextArea resultsArea;

    private JButton startButton;

    public RaceGUI() {

        setTitle("Algorithm Race");

        setSize(800, 500);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel title =
                new JLabel(
                        "Algorithm Race",
                        SwingConstants.CENTER);

        add(title,
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

    public JButton getStartButton() {

        return startButton;
    }

    public void appendResult(
            String text) {

        resultsArea.append(
                text + "\n");
    }

    public void clearResults() {

        resultsArea.setText("");
    }
}