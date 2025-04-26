package org.ubdev.task.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindKPairsSmallestSumsTest {

    private FindKPairsSmallestSums solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindKPairsSmallestSums();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums1, int[] nums2, int k, List<List<Integer>> expected) {
        // given

        // when
        List<List<Integer>> actual = solution.kSmallestPairs(nums1, nums2, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,7,11}, new int[]{2,4,6}, 3, List.of(List.of(1, 2), List.of(1, 4), List.of(1, 6))),
                Arguments.of(new int[]{1,1,2}, new int[]{1,2,3}, 2, List.of(List.of(1, 1), List.of(1, 1)))
        );
    }
}