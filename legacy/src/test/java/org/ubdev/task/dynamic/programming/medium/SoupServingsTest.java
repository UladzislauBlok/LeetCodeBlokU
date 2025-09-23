package org.ubdev.task.dynamic.programming.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SoupServingsTest {

    private SoupServings solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SoupServings();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, double expected) {
        // given

        // when
        double actual = solution.soupServings(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(50, 0.625),
                Arguments.of(100, 0.71875)
        );
    }
}