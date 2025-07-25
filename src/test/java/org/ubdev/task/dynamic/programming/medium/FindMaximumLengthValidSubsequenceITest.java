package org.ubdev.task.dynamic.programming.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMaximumLengthValidSubsequenceITest {

    private FindMaximumLengthValidSubsequenceI solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindMaximumLengthValidSubsequenceI();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.maximumLength(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4}, 4),
                Arguments.of(new int[]{1,2,1,1,2,1,2}, 6),
                Arguments.of(new int[]{1,3}, 2)
        );
    }
}