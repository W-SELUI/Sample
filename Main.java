import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<University> universities =
                CSVReader.loadUniversities(
                        "World University Rankings 2023-Cleaned.csv");

        CounterStatisticsExporter
                .exportStatistics(universities);
    }
}