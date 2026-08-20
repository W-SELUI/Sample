import java.util.Comparator;

public class NameComparator
        implements Comparator<University> {

    @Override
    public int compare(
            University u1,
            University u2) {

        return u1.getName()
                .compareToIgnoreCase(
                        u2.getName());
    }
}