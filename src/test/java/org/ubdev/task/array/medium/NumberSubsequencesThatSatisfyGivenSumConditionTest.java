package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSubsequencesThatSatisfyGivenSumConditionTest {

    private NumberSubsequencesThatSatisfyGivenSumCondition solution;

    @BeforeEach
    public void setUp() {
        this.solution = new NumberSubsequencesThatSatisfyGivenSumCondition();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int target, int expected) {
        // given

        // when
        int actual = solution.numSubseq(nums, target);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{3,5,6,7}, 9, 4),
                Arguments.of(new int[]{3,3,6,8}, 10, 6),
                Arguments.of(new int[]{2,3,3,4,6,7}, 12, 61)
        );
    }
}