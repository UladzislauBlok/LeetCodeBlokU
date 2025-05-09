package org.ubdev.task.array.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumCountPositiveIntegerNegativeIntegerTest {

    private MaximumCountPositiveIntegerNegativeInteger solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumCountPositiveIntegerNegativeInteger();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.maximumCount(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{-2,-1,-1,1,2,3}, 3),
                Arguments.of(new int[]{-3,-2,-1,0,0,1,2}, 3),
                Arguments.of(new int[]{5,20,66,1314}, 4)
        );
    }
}