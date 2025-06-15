package org.ubdev.task.greedy.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaxDifferenceYouCanGetFromChangingIntegerTest {

    private MaxDifferenceYouCanGetFromChangingInteger solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaxDifferenceYouCanGetFromChangingInteger();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int num, int expected) {
        // given

        // when
        int actual = solution.maxDiff(num);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(555, 888),
                Arguments.of(9, 8)
        );
    }
}