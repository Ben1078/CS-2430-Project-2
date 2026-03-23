package algorithmPerfomance;

import algorithmPerformance.QuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Tests for QuickSort.sort(). Covers: edge cases, correctness, exact comparison count, and worst-case.
 * @author Nelson Long
 */
public class QuickSortTest {

    @Test
    void QuickSort_EmptyArray() {
        int[] array = {};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void QuickSort_SingleElement() {
        int[] array = {42};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{42}, array);
    }

    @Test
    void QuickSort_AlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void QuickSort_ReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void QuickSort_Duplicates() {
        int[] array = {3, 1, 2, 1, 3};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, array);
    }

    @Test
    void QuickSort_AllSameElements() {
        int[] array = {7, 7, 7, 7};
        QuickSort.sort(array);
        assertArrayEquals(new int[]{7, 7, 7, 7}, array);
    }

    @Test
    void QuickSort_ReturnsComparisonCount() {
        int[] array = {3, 1, 2};
        int count = QuickSort.sort(array);
        Assertions.assertTrue(count > 0);
    }

    @Test
    void QuickSort_ExactComparisonCount() {
        int[] array = {2, 1};
        int count = QuickSort.sort(array);
        Assertions.assertEquals(1, count);
    }

    @Test
    void QuickSort_AlreadySorted_HighComparisonCount() {
        // Lomuto partition on an already-sorted array is the worst case (O(n^2) comparisons)
        int[] array = {1, 2, 3, 4, 5};
        int[] reverse = {5, 4, 3, 2, 1};
        int sortedCount = QuickSort.sort(array);
        int reverseCount = QuickSort.sort(reverse);
        Assertions.assertTrue(sortedCount >= reverseCount);
    }
}
