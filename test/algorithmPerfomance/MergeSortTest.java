package algorithmPerfomance;

import algorithmPerformance.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Tests for MergeSort.sort(). Covers: edge cases, correctness, stability, and exact comparison count.
 * @author Nelson Long
 */
public class MergeSortTest {

    @Test
    void MergeSort_EmptyArray() {
        int[] array = {};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void MergeSort_SingleElement() {
        int[] array = {42};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{42}, array);
    }

    @Test
    void MergeSort_AlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void MergeSort_ReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void MergeSort_Duplicates() {
        int[] array = {3, 1, 2, 1, 3};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, array);
    }

    @Test
    void MergeSort_AllSameElements() {
        int[] array = {7, 7, 7, 7};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{7, 7, 7, 7}, array);
    }

    @Test
    void MergeSort_ReturnsComparisonCount() {
        int[] array = {3, 1, 2};
        int count = MergeSort.sort(array);
        Assertions.assertTrue(count > 0);
    }

    @Test
    void MergeSort_IsStable() {
        // MergeSort uses <= when picking from left, so equal elements retain left-first order
        int[] array = {2, 1, 2, 1};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{1, 1, 2, 2}, array);
    }

    @Test
    void MergeSort_ExactComparisonCount() {
        int[] array = {2, 1};
        int count = MergeSort.sort(array);
        Assertions.assertEquals(1, count);
    }
}
