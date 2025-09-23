package org.ubdev.task.math.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumKnMirrorNumbersTest {

    private SumKnMirrorNumbers solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SumKnMirrorNumbers();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int k, long expected) {
        // given

        // when
        long actual = solution.kMirror(n, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(2,5,25),
                Arguments.of(3,7,499),
                Arguments.of(7,17,20379000)
        );
    }
}