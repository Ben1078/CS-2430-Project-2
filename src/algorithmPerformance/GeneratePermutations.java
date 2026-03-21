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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * intakes permutation size n
 * outputs all permutations in a list of integer arrays
 * ex. n = 2 -> {[0, 1], [1, 0]}
 */
public class GeneratePermutations {
    public static List<int[]> generate(int n) {
        // if n is less than one there are no permutations
        if (n < 1) {
            return new ArrayList<>();
        }
        // initialize the first permutation in ascending order
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = i;
        }
        // initialize the list of permutations
        // the starting permutation is always the smallest arrangement
        List<int[]> permutations = new ArrayList<>();
        // initialize last to be the index of the last int in the permutation
        int last = n - 1;

        while (true) {
            // add a copy of the current permutation to permutations
            permutations.add(Arrays.copyOf(ar, ar.length));
            // initialize pointer j to be one before last
            int j = last - 1;
            // find the index closest to the end that can be swapped to increase the permutation
            // ex. [1, 0, 2, 4, 5] -> ar[3] - 4
            // if ar[j] is always >= ar[j+1] the permutation is in descending order and all permutations have been found
            while (j >= 0 && ar[j] >= ar[j + 1]) {
                j--;
            }
            if (j < 0) {
                break;
            }
            // initialize pointer k to last
            int k = last;
            // find the index closest to the end that can be swapped with j to increase the permutation
            // ex. [1, 0, 2, 4, 5] j = ar[3] - 4 -> ar[4] - 5
            while (ar[j] >= ar[k]) {
                k--;
            }
            // swap ar[j] and ar[k]
            int temp = ar[k];
            ar[k] = ar[j];
            ar[j] = temp;

            int left = j + 1;
            int right = last;
            // flip the array after index j + 1 to find only the next largest permutation
            // ex. [0, 2, 4, 3, 1] j = ar[1] = - 2  -> [0, 2, 1, 3, 4]
            while (left < right) {
                temp = ar[left];
                ar[left] = ar[right];
                ar[right] = temp;
                left++;
                right--;
            }
        }

        return permutations;
    }
}
