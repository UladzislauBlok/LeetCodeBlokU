package org.ubdev.task.binary.search.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumTimeRepairCarsTest {

    private MinimumTimeRepairCars solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumTimeRepairCars();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] ranks, int cars, long expected) {
        // given

        // when
        long actual = solution.repairCars(ranks, cars);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{4,2,3,1}, 10, 16),
                Arguments.of(new int[]{5,1,8}, 6, 16)
        );
    }
}