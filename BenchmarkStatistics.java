public class BenchmarkStatistics {

    private long best;
    private long mean;
    private long median;
    private long worst;

    public BenchmarkStatistics(
            long best,
            long mean,
            long median,
            long worst) {

        this.best = best;
        this.mean = mean;
        this.median = median;
        this.worst = worst;
    }

    public long getBest() {
        return best;
    }

    public long getMean() {
        return mean;
    }

    public long getMedian() {
        return median;
    }

    public long getWorst() {
        return worst;
    }

    @Override
    public String toString() {

        return "Best: " + best
                + " | Mean: " + mean
                + " | Median: " + median
                + " | Worst: " + worst;
    }
}