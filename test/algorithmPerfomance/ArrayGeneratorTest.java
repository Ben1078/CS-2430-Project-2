package algorithmPerfomance;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import algorithmPerformance.GeneratePermutations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for GeneratePermutations.generate(n).
 * Covers: empty/negative input, correct output values, no duplicates, and required n sizes (4, 6, 8).
 * @author Nelson Long
 */
public class ArrayGeneratorTest {
    @Test
    void GeneratePermutations_EmptyArray_Size() {
        List<int[]> result = GeneratePermutations.generate(0);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void GeneratePermutations_SingleArray_Size() {
        List<int[]> result = GeneratePermutations.generate(1);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    void GeneratePermutations_ThreeArray_Size() {
        List<int[]> result = GeneratePermutations.generate(3);
        Assertions.assertEquals(6, result.size());
    }

    @Test
    void GeneratePermutations_NegativeArray_Size() {
        List<int[]> result = GeneratePermutations.generate(-1);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void GeneratePermutations_TwoArray_Results() {
        List<int[]> result = GeneratePermutations.generate(2);
        int[][] expected = {{0, 1}, {1, 0}};

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result.get(i));
        }
    }

    @Test
    void GeneratePermutations_ThreeArray_Results() {
        List<int[]> result = GeneratePermutations.generate(3);
        int[][] expected = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result.get(i));
        }
    }

    @Test
    void GeneratePermutations_N4_Size() {
        List<int[]> result = GeneratePermutations.generate(4);
        Assertions.assertEquals(24, result.size()); // 4! = 24
    }

    @Test
    void GeneratePermutations_N6_Size() {
        List<int[]> result = GeneratePermutations.generate(6);
        Assertions.assertEquals(720, result.size()); // 6! = 720
    }

    @Test
    void GeneratePermutations_N8_Size() {
        List<int[]> result = GeneratePermutations.generate(8);
        Assertions.assertEquals(40320, result.size()); // 8! = 40320
    }

    @Test
    void GeneratePermutations_NoDuplicates() {
        List<int[]> result = GeneratePermutations.generate(3);
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                Assertions.assertFalse(Arrays.equals(result.get(i), result.get(j)),
                        "Duplicate found: " + Arrays.toString(result.get(i)));
            }
        }
    }

    @Test
    void GeneratePermutations_BoundarySize() {
        List<int[]> tooSmall = GeneratePermutations.generate(-1);
        Assertions.assertEquals(0, tooSmall.size());

        List<int[]> tooLarge = GeneratePermutations.generate(8);
        Assertions.assertEquals(40320, tooLarge.size()); // 8!
    }
}
