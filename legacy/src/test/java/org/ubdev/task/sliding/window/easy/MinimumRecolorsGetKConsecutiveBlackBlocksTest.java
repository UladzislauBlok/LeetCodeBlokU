package org.ubdev.task.sliding.window.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumRecolorsGetKConsecutiveBlackBlocksTest {

    private MinimumRecolorsGetKConsecutiveBlackBlocks solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumRecolorsGetKConsecutiveBlackBlocks();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String blocks, int k, int expected) {
        // given

        // when
        int actual = solution.minimumRecolors(blocks, k);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("BWBBWWBBBWBWWWBWWBBWBWBBWBB", 11, 4),
                Arguments.of("W", 1, 1),
                Arguments.of("WBB", 1, 0),
                Arguments.of("WBBWWBBWBW", 7, 3),
                Arguments.of("WBWBBBW", 2, 0)
        );
    }
}