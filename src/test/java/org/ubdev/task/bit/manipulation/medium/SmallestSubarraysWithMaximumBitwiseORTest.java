package org.ubdev.task.bit.manipulation.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestSubarraysWithMaximumBitwiseORTest {

    private SmallestSubarraysWithMaximumBitwiseOR solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SmallestSubarraysWithMaximumBitwiseOR();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int[] expected) {
        // given

        // when
        int[] actual = solution.smallestSubarrays(nums);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,0,2,1,3}, new int[]{3,3,2,2,1}),
                Arguments.of(new int[]{1,2}, new int[]{2,1})
        );
    }
}