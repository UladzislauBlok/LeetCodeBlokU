package org.ubdev.task.array.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumDifferenceBetweenIncreasingElementsTest {

    private MaximumDifferenceBetweenIncreasingElements solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumDifferenceBetweenIncreasingElements();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.maximumDifference(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{7,1,5,4}, 4),
                Arguments.of(new int[]{9,4,3,2}, -1),
                Arguments.of(new int[]{1,5,2,10}, 9)
        );
    }
}