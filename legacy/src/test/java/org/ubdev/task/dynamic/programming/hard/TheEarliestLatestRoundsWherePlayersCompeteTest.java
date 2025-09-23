package org.ubdev.task.dynamic.programming.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TheEarliestLatestRoundsWherePlayersCompeteTest {

    private TheEarliestLatestRoundsWherePlayersCompete solution;

    @BeforeEach
    public void setUp() {
        this.solution = new TheEarliestLatestRoundsWherePlayersCompete();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int firstPlayer, int secondPlayer, int[] expected) {
        // given

        // when
        int[] actual = solution.earliestAndLatest(n, firstPlayer, secondPlayer);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(11, 2, 4, new int[]{3,4}),
                Arguments.of(5, 1, 5, new int[]{1,1})
        );
    }
}