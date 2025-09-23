package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumMatchingPlayersWithTrainersTest {

    private MaximumMatchingPlayersWithTrainers solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumMatchingPlayersWithTrainers();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] players, int[] trainers, int expected) {
        // given

        // when
        int actual = solution.matchPlayersAndTrainers(players, trainers);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{4,7,9}, new int[]{8,2,5,8}, 2),
                Arguments.of(new int[]{1,1,1}, new int[]{10}, 1)
        );
    }
}