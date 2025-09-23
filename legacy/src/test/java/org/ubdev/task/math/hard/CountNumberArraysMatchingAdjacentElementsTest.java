package org.ubdev.task.math.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountNumberArraysMatchingAdjacentElementsTest {

    private CountNumberArraysMatchingAdjacentElements solution;

    @BeforeEach
    public void setUp() {
        this.solution = new CountNumberArraysMatchingAdjacentElements();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int m, int k, int expected) {
        // given

        // when
        int actual = solution.numberOfGoodArrays(n, m, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(3,2,1,4),
                Arguments.of(4,2,2,6),
                Arguments.of(5,2,0,2)
        );
    }
}