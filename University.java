public class University {

    private int rank;
    private String name;
    private String location;
    private double overallScore;

    public University(int rank,
                      String name,
                      String location,
                      double overallScore) {

        this.rank = rank;
        this.name = name;
        this.location = location;
        this.overallScore = overallScore;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getOverallScore() {
        return overallScore;
    }

    @Override
    public String toString() {

        return rank + " | "
                + name + " | "
                + location + " | "
                + overallScore;
    }
}