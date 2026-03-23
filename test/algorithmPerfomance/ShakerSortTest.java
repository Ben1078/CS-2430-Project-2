package algorithmPerfomance;

import algorithmPerformance.ShakerSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Tests for ShakerSort.sort(). Covers: edge cases, correctness, exact comparison count, and early-exit on sorted input.
 * @author Nelson Long
 */
public class ShakerSortTest {

    @Test
    void ShakerSort_EmptyArray() {
        int[] array = {};
        ShakerSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void ShakerSort_SingleElement() {
        int[] array = {42};
        ShakerSort.sort(array);
        assertArrayEquals(new int[]{42}, array);
    }

    @Test
    void ShakerSort_AlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        ShakerSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void ShakerSort_ReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        ShakerSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void ShakerSort_Duplicates() {
        int[] array = {3, 1, 2, 1, 3};
        ShakerSort.sort(array);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, array);
    }

    @Test
    void ShakerSort_AllSameElements() {
        int[] array = {7, 7, 7, 7};
        ShakerSort.sort(array);
        assertArrayEquals(new int[]{7, 7, 7, 7}, array);
    }

    @Test
    void ShakerSort_ReturnsComparisonCount() {
        int[] array = {3, 1, 2};
        int count = ShakerSort.sort(array);
        Assertions.assertTrue(count > 0);
    }

    @Test
    void ShakerSort_ExactComparisonCount() {
        int[] array = {2, 1};
        int count = ShakerSort.sort(array);
        Assertions.assertEquals(1, count);
    }

    @Test
    void ShakerSort_AlreadySorted_LowComparisonCount() {
        // ShakerSort breaks early when no swaps occur, so a sorted array should have fewer comparisons
        int[] sorted = {1, 2, 3, 4, 5};
        int[] unsorted = {5, 1, 4, 2, 3};
        int sortedCount = ShakerSort.sort(sorted);
        int unsortedCount = ShakerSort.sort(unsorted);
        Assertions.assertTrue(sortedCount < unsortedCount);
    }
}
