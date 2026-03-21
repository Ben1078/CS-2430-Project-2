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

public class AlgorithmPerformance {

    public static void main(String[] args) {
        // all the n values that will be tested
        int[] range = {4, 6, 8};
        // all the algorithms that will be tested
        SortingAlgorithm[] algorithms = {
                MergeSort::sort,
                QuickSort::sort,
                ShakerSort::sort,
                HeapSort::sort
        };
        // names of the algorithms being tested
        // the index of the name must equal the index of its corresponding algorithm
        String[] nameIndex  = {
                "Merge Sort",
                "Quick Sort",
                "Shaker Sort",
                "Heap Sort"
        };


        //TestDriver.test(n, algorithms[0], nameIndex[0]);

        // call test driver on each algorithm
        for (int i = 0; i < algorithms.length; i++) {
            TestDriver.test(range, algorithms[i], nameIndex[i]);
        }
    }
}
