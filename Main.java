import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<University> universities =
                CSVReader.loadUniversities(
                        "World University Rankings 2023-Cleaned.csv");

        System.out.println(
                "Dataset loaded successfully.");

        StatisticsExporter
                .exportStatistics(
                        universities);

        CounterStatisticsExporter
                .exportStatistics(
                        universities);

        StructureStatisticsExporter
                .exportStatistics(
                        universities);

        System.out.println(
                "StatisticsResults.csv generated.");

        System.out.println(
                "CounterStatistics.csv generated.");

        System.out.println(
                "StructureStatistics.csv generated.");

        System.out.println(
                "Launching Algorithm Grand Prix...");

        RaceAnimationDemo.main(args);
    }
}