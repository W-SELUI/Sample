public class RaceResult
        implements Comparable<RaceResult> {

    private String algorithmName;

    private long executionTime;

    public RaceResult(
            String algorithmName,
            long executionTime) {

        this.algorithmName =
                algorithmName;

        this.executionTime =
                executionTime;
    }

    public String getAlgorithmName() {

        return algorithmName;
    }

    public long getExecutionTime() {

        return executionTime;
    }

    @Override
    public int compareTo(
            RaceResult other) {

        return Long.compare(
                this.executionTime,
                other.executionTime);
    }
}