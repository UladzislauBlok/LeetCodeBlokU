package org.ubdev.task.dynamic.programming.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMaximumNumberFruitsCollectedTest {

    private FindMaximumNumberFruitsCollected solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindMaximumNumberFruitsCollected();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] fruits, int expected) {
        // given

        // when
        int actual = solution.maxCollectedFruits(fruits);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2,3,4},{5,6,8,7},{9,10,11,12},{13,14,15,16}}, 100),
                Arguments.of(new int[][]{{1,1},{1,1}}, 4),
                Arguments.of(new int[][]{{11,17,13,0,18},{13,12,10,12,19},{4,8,10,14,16},{2,13,12,7,16},{4,9,7,4,3}}, 145)
        );
    }
}