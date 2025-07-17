package org.ubdev.task.dynamic.programming.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMaximumLengthValidSubsequenceIITest {

    private FindMaximumLengthValidSubsequenceII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindMaximumLengthValidSubsequenceII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int k, int expected) {
        // given

        // when
        int actual = solution.maximumLength(nums, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5}, 2, 5),
                Arguments.of(new int[]{1,4,2,3,1,4}, 3, 4)
        );
    }
}