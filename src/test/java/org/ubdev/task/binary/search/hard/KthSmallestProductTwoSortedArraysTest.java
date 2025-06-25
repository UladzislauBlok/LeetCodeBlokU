package org.ubdev.task.binary.search.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class KthSmallestProductTwoSortedArraysTest {

    private KthSmallestProductTwoSortedArrays solution;

    @BeforeEach
    public void setUp() {
        this.solution = new KthSmallestProductTwoSortedArrays();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums1, int[] nums2, long k, long expected) {
        // given

        // when
        long actual = solution.kthSmallestProduct(nums1, nums2, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2,5}, new int[]{3,4}, 2, 8),
                Arguments.of(new int[]{-4,-2,0,3}, new int[]{2,4}, 6, 0),
                Arguments.of(new int[]{-2,-1,0,1,2}, new int[]{-3,-1,2,4,5}, 3, -6)
        );
    }
}