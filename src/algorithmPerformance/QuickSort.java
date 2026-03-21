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

public class QuickSort {
    /**
     * container method to implement comparison count
     * mutates original array
     * @param ar unsorted array
     * @return comparison count
     */
    public static int sort(int[] ar) {
        int[] comparisonCount = { 0 };

        // Kick off the recursion using the full array bounds
        quickSortRecursive(ar, 0, ar.length - 1, comparisonCount);

        return comparisonCount[0];
    }

    /**
     * Using standard Lomuto partition (O(n^2) on already sorted arrays)
     * @param ar unsorted array
     * @param low the bottom of the range that will be sorted
     * @param high to top of the range that will be sorted
     * @param comparisonCount tracker
     */
    public static void quickSortRecursive(int[] ar, int low, int high, int[] comparisonCount) {
        // base case
        if (low >= high) {
            return;
        }
        // define pointers and pivot
        int i = low - 1, j = low;
        int pivot = ar[high];

        while (j < high) {
            comparisonCount[0]++;
            // if ar[j] is less than the pivot we increment i and swap ar[i] and ar[j]
            if (ar[j] < pivot) {
                i++;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
            // if ar[j] is greater than or equal to the pivot we only increment j
            j++;
        }
        // swap pivot with ar[i+1]
        i++;
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
        // now everything before i is <= the pivot
        // call quickSort on the left and right side of the pivot to recursively sort until low >= high
        quickSortRecursive(ar, low, i - 1, comparisonCount);
        quickSortRecursive(ar, i + 1, high, comparisonCount);

        return;
    }
}
