package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DivideArrayIntoArraysWithMaxDifferenceTest {

    private DivideArrayIntoArraysWithMaxDifference solution;

    @BeforeEach
    public void setUp() {
        this.solution = new DivideArrayIntoArraysWithMaxDifference();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int k, int[][] expected) {
        // given

        // when
        int[][] actual = solution.divideArray(nums, k);

        // then
        assertThat(actual).isDeepEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,3,4,8,7,9,3,5,1}, 2, new int[][]{{1,1,3},{3,4,5},{7,8,9}}),
                Arguments.of(new int[]{2,4,2,2,5,2}, 2, new int[][]{}),
                Arguments.of(new int[]{4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11}, 14,
                        new int[][]{{2,2,2},{4,5,5},{5,5,7},{7,8,8},{9,9,10},{11,12,12}})
        );
    }
}