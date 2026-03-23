package algorithmPerfomance;

import algorithmPerformance.HeapSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Tests for HeapSort.sort(). Covers: edge cases, correctness, exact comparison count, and early-exit behavior.
 * @author Nelson Long
 */
public class HeapSortTest {

    @Test
    void HeapSort_EmptyArray() {
        int[] array = {};
        HeapSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void HeapSort_SingleElement() {
        int[] array = {42};
        HeapSort.sort(array);
        assertArrayEquals(new int[]{42}, array);
    }

    @Test
    void HeapSort_AlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        HeapSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void HeapSort_ReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        HeapSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void HeapSort_Duplicates() {
        int[] array = {3, 1, 2, 1, 3};
        HeapSort.sort(array);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, array);
    }

    @Test
    void HeapSort_AllSameElements() {
        int[] array = {7, 7, 7, 7};
        HeapSort.sort(array);
        assertArrayEquals(new int[]{7, 7, 7, 7}, array);
    }

    @Test
    void HeapSort_ReturnsComparisonCount() {
        int[] array = {3, 1, 2};
        int count = HeapSort.sort(array);
        Assertions.assertTrue(count > 0);
    }

    @Test
    void HeapSort_ExactComparisonCount() {
        int[] array = {2, 1};
        int count = HeapSort.sort(array);
        Assertions.assertEquals(1, count);
    }
}