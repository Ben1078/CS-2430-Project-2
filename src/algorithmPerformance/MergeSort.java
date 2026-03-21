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

public class MergeSort {
    /**
     * container method to implement comparison count
     * mutates original array
     * @param ar unsorted array
     * @return comparison count
     */
    public static int sort(int[] ar) {
        int[] comparisonCount = { 0 };
        int[] sortedArray = mergeSortRecursive(ar, comparisonCount);
        System.arraycopy(sortedArray, 0, ar, 0, ar.length);
        return comparisonCount[0];
    }
    public static int[] mergeSortRecursive(int[] ar, int[] comparisonCount) {
        // base case
        if (ar.length <= 1) {
            return ar;
        }
        // finds the mid-point of the array and splits it in half
        int mid = ar.length / 2;
        int[] left = Arrays.copyOfRange(ar, 0, mid);
        int[] right = Arrays.copyOfRange(ar, mid, ar.length);
        // recursively calls split, bottom layer has length 1
        left = mergeSortRecursive(left, comparisonCount);
        right = mergeSortRecursive(right, comparisonCount);

        // each recursion calls combine resulting in full length sorted list
        return combine(left, right, comparisonCount);


    }

    public static int[] combine(int[] left, int[] right, int[] comparisonCount) {
        int[] result = new int[left.length + right.length];
        // sets up pointers for left list (i), right list (j), and result list (k)
        int i = 0, j = 0, k = 0;
        // compare integers from left and right until one list is fully sorted
        while (i < left.length && j < right.length) {
            comparisonCount[0]++;
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        // if left hasn't been sorted add the remaining integers to result
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }
        // if right hasn't been sorted add the remaining integers to result
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }
}
