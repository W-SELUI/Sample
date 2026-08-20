import java.util.Comparator;

public class ScoreComparator
        implements Comparator<University> {

    @Override
    public int compare(
            University u1,
            University u2) {

        return Double.compare(
                u1.getOverallScore(),
                u2.getOverallScore());
    }
}