package org.ubdev.task.math.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTotalNumberColoredCellsTest {

    private CountTotalNumberColoredCells solution;

    @BeforeEach
    public void setUp() {
        this.solution = new CountTotalNumberColoredCells();
    }

    @ParameterizedTest
    @MethodSource
    void coloredCellsOfThreeReturnsExpectedResult(int input, long expected) {
        // given

        // when
        long actual = solution.coloredCells(input);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> coloredCellsOfThreeReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 5)
        );
    }
}