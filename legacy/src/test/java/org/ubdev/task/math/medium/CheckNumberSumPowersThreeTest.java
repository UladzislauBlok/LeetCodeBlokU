package org.ubdev.task.math.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckNumberSumPowersThreeTest {

    private CheckNumberSumPowersThree solution;

    @BeforeEach
    public void setUp() {
        this.solution = new CheckNumberSumPowersThree();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int input, boolean expected) {
        // given

        // when
        boolean actual = solution.checkPowersOfThree(input);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(12, true),
                Arguments.of(91, true),
                Arguments.of(21, false)
        );
    }
}