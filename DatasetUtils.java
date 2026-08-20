import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DatasetUtils {

    public static List<University> getSubset(
            List<University> universities,
            int size) {

        return new ArrayList<>(
                universities.subList(0, size));
    }

    public static ArrayList<University> getArrayList(
            List<University> universities,
            int size) {

        return new ArrayList<>(
                universities.subList(0, size));
    }

    public static LinkedList<University> getLinkedList(
            List<University> universities,
            int size) {

        return new LinkedList<>(
                universities.subList(0, size));
    }
}