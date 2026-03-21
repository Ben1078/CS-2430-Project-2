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

public class HeapSort {
    /**
     * heapify's int[], swaps top node with leaf and excludes leaf, then repeats
     * mutates original array
     * @param ar unsorted array
     * @return comparison count
     */
    public static int sort(int[] ar) {
        // initialize n to ar.length since no leafs are excluded
        int n = ar.length;
        int[] comparisonCount = { 0 };
        // run heapify on all i values that can have leafs
        for (int i = n / 2 - 1; i >= 0 ; i--) {
            heapify(ar, n, i, comparisonCount);
        }
        // swap the top node with the last leaf then heapify excluding the leaf
        // repeats until list is fully sorted
        for (int i = n - 1; i > 0; i--) {
            int temp = ar[i];
            ar[i] = ar[0];
            ar[0] = temp;

            heapify(ar, i, 0, comparisonCount);
        }

        return comparisonCount[0];
    }

    /**
     * places a node in its correct place on a descending tree
     * @param ar unsorted array
     * @param n length of included heap
     * @param i index of the assumed largest node
     * @param comparisonCount tracker
     */
    public static void heapify(int[] ar, int n, int i, int[] comparisonCount) {
        int largest = i;
        // identify the index's of largest's children
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;

        if (leftChild < n) {
            // if left child exists increment comparisonCount
            comparisonCount[0]++;
            // if the left child is larger than its parent set largest to left child
            if (ar[leftChild] > ar[largest]) {
                largest = leftChild;
            }
        }

        if (rightChild < n) {
            // if right child exists increment comparisonCount
            comparisonCount[0]++;
            // if the right child is larger than its parent set largest to left child
            if (ar[rightChild] > ar[largest]) {
                largest = rightChild;
            }
        }
        // if the index assumed largest was smaller than a child swap that child and largest in the array
        // recursively heapify the original node i until it is correctly placed
        if (largest != i) {
            int temp = ar[i];
            ar[i] = ar[largest];
            ar[largest] = temp;

            heapify(ar, n, largest, comparisonCount);
        }
    }
}
