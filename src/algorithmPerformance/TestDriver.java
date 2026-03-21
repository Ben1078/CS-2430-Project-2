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
import java.util.Collections;
import java.util.List;

public class TestDriver {
    /**
     * prints the average, best 10, and worst 10 comparison counts for all permutations n in range
     * using the algorithm provided
     *
     * @param ranges all n values
     * @param algorithm algorithm to be tested
     * @param name name of algorithm tested
     */
    public static void test(int[] ranges, SortingAlgorithm algorithm, String name) {
        // for each n sort and print the results
        for (int n : ranges) {
            List<int[]> permutations = GeneratePermutations.generate(n);
            List<SortResult> results = new ArrayList<>();
            // sorts the permutation and adds results and original permutation to results List as an object
            for (int[] permutation : permutations) {
                // clone permutation to keep unsorted array
                int[] temp = permutation.clone();
                results.add(new SortResult(algorithm.sort(permutation), temp));
            }
            // sort results to ascending order based off comparison count
            Collections.sort(results);
            List<SortResult> topResults = new ArrayList<>(results.subList(0, 10));
            List<SortResult> bottomResults = new ArrayList<>(results.subList(results.size() - 10, results.size()));
            // reverse bottom results so worst cases are at the beginning
            Collections.reverse(bottomResults);

            double average = 0;
            for (SortResult result : results) {
                average = average + result.getComparisons();
            }
            // calculate average comparison count
            average = average / results.size();

            System.out.printf("Average Comparison for %s (n=%s): %.2f%n", name, n, average);
            System.out.printf("Top 10 results for %s (n=%s):%n", name, n);
            // print best results
            for (SortResult result : topResults) {
                System.out.println(result);
            }

            System.out.printf("%nBottom 10 results for %s (n=%s):%n", name, n);
            // print worst results
            for (SortResult result : bottomResults) {
                System.out.println(result);
            }

            System.out.printf("%n-------------------------------------------------------- %n%n");

        }
    }
}
