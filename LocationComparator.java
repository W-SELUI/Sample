import java.util.Comparator;

public class LocationComparator
        implements Comparator<University> {

    @Override
    public int compare(
            University u1,
            University u2) {

        return u1.getLocation()
                .compareToIgnoreCase(
                        u2.getLocation());
    }
}