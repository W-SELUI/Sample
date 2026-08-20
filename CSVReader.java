import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<University> loadUniversities(String filePath) {

        List<University> universities = new ArrayList<>();

        try (BufferedReader reader =
                new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] data =
                    line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                int rank = Integer.parseInt(data[0].trim());

                String name = data[1]
                        .replace("\"", "")
                        .trim();

                String location = data[2].trim();

                double overallScore = parseScore(data[7]);

                universities.add(
                    new University(
                        rank,
                        name,
                        location,
                        overallScore));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return universities;
    }

    private static double parseScore(String scoreText) {

        try {

            scoreText = scoreText.trim();

            if (scoreText.isEmpty()) {
                return 0.0;
            }

            if (scoreText.contains("–")) {
                scoreText =
                    scoreText.split("–")[0];
            }

            return Double.parseDouble(scoreText);

        } catch (Exception e) {
            return 0.0;
        }
    }
}