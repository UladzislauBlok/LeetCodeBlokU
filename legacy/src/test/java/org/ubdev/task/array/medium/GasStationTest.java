package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GasStationTest {

    private GasStation solution;

    @BeforeEach
    public void setUp() {
        this.solution = new GasStation();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] gas, int[] cost, int expected) {
        // given

        // when
        int actual = solution.canCompleteCircuit(gas, cost);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}, 3),
                Arguments.of(new int[]{2,3,4}, new int[]{3,4,3}, -1),
                Arguments.of(new int[]{3,1,1}, new int[]{1,2,2}, 0)
        );
    }
}