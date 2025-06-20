package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumManhattanDistanceAfterKChangesTest {

    private MaximumManhattanDistanceAfterKChanges solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumManhattanDistanceAfterKChanges();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String input, int k, int expected) {
        // given

        // when
        int actual = solution.maxDistance(input, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("NWSE", 1, 3),
                Arguments.of("NSWWEW", 3, 6)
        );
    }
}