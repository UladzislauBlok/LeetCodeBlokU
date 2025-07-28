package org.ubdev.task.backtracking.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountNumberMaximumBitwiseORSubsetsTest {

    private CountNumberMaximumBitwiseORSubsets solution;

    @BeforeEach
    public void setUp() {
        this.solution = new CountNumberMaximumBitwiseORSubsets();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.countMaxOrSubsets(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{3,1}, 2),
                Arguments.of(new int[]{2,2,2}, 7),
                Arguments.of(new int[]{3,2,1,5}, 6)
        );
    }
}