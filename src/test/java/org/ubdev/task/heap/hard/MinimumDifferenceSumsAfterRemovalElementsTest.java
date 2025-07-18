package org.ubdev.task.heap.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumDifferenceSumsAfterRemovalElementsTest {

    private MinimumDifferenceSumsAfterRemovalElements solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumDifferenceSumsAfterRemovalElements();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        long actual = solution.minimumDifference(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{3,1,2}, -1),
                Arguments.of(new int[]{7,9,5,8,1,3}, 1)
        );
    }
}