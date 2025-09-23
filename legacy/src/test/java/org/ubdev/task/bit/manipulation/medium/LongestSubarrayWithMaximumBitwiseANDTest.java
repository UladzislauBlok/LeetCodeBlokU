package org.ubdev.task.bit.manipulation.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubarrayWithMaximumBitwiseANDTest {

    private LongestSubarrayWithMaximumBitwiseAND solution;

    @BeforeEach
    public void setUp() {
        this.solution = new LongestSubarrayWithMaximumBitwiseAND();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.longestSubarray(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,3,2,2}, 2),
                Arguments.of(new int[]{1,2,3,4}, 1)
        );
    }
}