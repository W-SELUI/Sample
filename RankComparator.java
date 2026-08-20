import java.util.Comparator;

public class RankComparator
        implements Comparator<University> {

    @Override
    public int compare(
            University u1,
            University u2) {

        return Integer.compare(
                u1.getRank(),
                u2.getRank());
    }
}