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

public class ShakerSort {
    /**
     * mutates original array
     * @param ar unsorted array
     * @return comparison count
     */
    public static int sort(int[] ar) {
        int comparisonCount = 0;
        int start = 0;
        int end = ar.length - 1;
        // initialize swapped to true for the first iteration
        boolean swapped = true;

        while (swapped) {
            // once while loop starts set swapped to false
            swapped = false;
            // iterate through ar from start to end, if ar[i] > ar[i+1] swap
            // once the for loop ends index at end is sorted
            for (int i = start; i < end; i++) {
                comparisonCount++;
                if (ar[i] > ar[i + 1]) {
                    int temp = ar[i];
                    ar[i] = ar[i + 1];
                    ar[i + 1] = temp;
                    swapped = true;
                }
            }
            // if nothing was swapped last iteration the list is sorted
            if (!swapped) {
                break;
            }
            // reset swapped and move end 1 left since ar[end] is sorted
            swapped = false;
            end--;
            // iterate through ar from end to start, if ar[i] > ar[i+1] swap
            // once the for loop ends index at start is sorted
            for (int i = end; i >= start; i--) {
                comparisonCount++;
                if (ar[i] > ar[i + 1]) {
                    int temp = ar[i];
                    ar[i] = ar[i + 1];
                    ar[i + 1] = temp;
                    swapped = true;
                }
            }
            // move start 1 right since ar[start] is sorted
            start++;
        }
        return comparisonCount;
    }
}
