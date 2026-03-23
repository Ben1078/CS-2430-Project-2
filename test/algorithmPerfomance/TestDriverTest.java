package algorithmPerfomance;

import algorithmPerformance.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Tests for TestDriver.test(). Verifies all four algorithms run without error for required n values (4, 6, 8).
 * @author Nelson Long
 */
public class TestDriverTest {

    @Test
    void TestDriver_RunsWithoutError_MergeSort() {
        int[] range = {4, 6, 8};
        assertDoesNotThrow(() -> TestDriver.test(range, MergeSort::sort, "Merge Sort"));
    }

    @Test
    void TestDriver_RunsWithoutError_QuickSort() {
        int[] range = {4, 6, 8};
        assertDoesNotThrow(() -> TestDriver.test(range, QuickSort::sort, "Quick Sort"));
    }

    @Test
    void TestDriver_RunsWithoutError_ShakerSort() {
        int[] range = {4, 6, 8};
        assertDoesNotThrow(() -> TestDriver.test(range, ShakerSort::sort, "Shaker Sort"));
    }

    @Test
    void TestDriver_RunsWithoutError_HeapSort() {
        int[] range = {4, 6, 8};
        assertDoesNotThrow(() -> TestDriver.test(range, HeapSort::sort, "Heap Sort"));
    }
}
