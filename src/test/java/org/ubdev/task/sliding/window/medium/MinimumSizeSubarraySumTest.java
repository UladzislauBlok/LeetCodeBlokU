package org.ubdev.task.sliding.window.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumSizeSubarraySumTest {

    private MinimumSizeSubarraySum solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumSizeSubarraySum();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int target, int expected) {
        // given

        // when
        int actual = solution.minSubArrayLen(target, nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2,3,1,2,4,3}, 7, 2),
                Arguments.of(new int[]{1,4,4}, 4, 1),
                Arguments.of(new int[]{1,1,1,1,1,1,1,1}, 11, 0)

        );
    }
}