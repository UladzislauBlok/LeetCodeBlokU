package org.ubdev.task.dynamic.programming.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PaintingGridWithThreeDifferentColorsTest {

    private PaintingGridWithThreeDifferentColors solution;

    @BeforeEach
    public void setUp() {
        this.solution = new PaintingGridWithThreeDifferentColors();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int m, int n, int expected) {
        // given

        // when
        int actual = solution.colorTheGrid(m, n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(1, 1, 3),
                Arguments.of(1, 2, 6),
                Arguments.of(5, 5, 580986)
        );
    }
}