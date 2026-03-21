/*
 * Team Name - Team Awesome Sauce
 * Team Members - Noah Kolling, Nelson Long, & Ben Paul
 * CS-2430-502-Spring 2026
 * Programming Project 2 - Programming Project 2: Algorithm Performance
 * @author Ben Paul (Primary Author)
 * @author Nelson Long (Secondary Author)
 * @author Noah Kolling (Secondary Author)
 */


package algorithmPerformance;

import java.util.Arrays;

public class SortResult implements Comparable<SortResult> {
    int comparisons;
    int[] permutation;
    String algorithm;

    /**
     * stores comparison count and its corresponding permutation
     * @param comparisons num of comparisons from sorting run
     * @param permutation permutation that was sorted
     */
    public SortResult(int comparisons, int[] permutation) {
        this.permutation = permutation;
        this.comparisons = comparisons;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int[] getPermutation() {
        return permutation;
    }

    /**
     * prints SortResult in the format below
     * "Comparisons: {comparisons} Permutation: {permutation}"
     * @return
     */
    @Override
    public String toString() {
        return String.format("Comparisons: %s Permutation: %s", this.comparisons, Arrays.toString(this.permutation));
    }

    /**
     * Override compareTo for Comparable .sort() functionality
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(SortResult other) {
        return Integer.compare(this.getComparisons(), other.getComparisons());
    }
}
