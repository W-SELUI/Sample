public class SortMetrics {

    private long comparisons;
    private long moves;

    public SortMetrics() {
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementMoves() {
        moves++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getMoves() {
        return moves;
    }

    public long getTotalOperations() {
        return comparisons + moves;
    }
}