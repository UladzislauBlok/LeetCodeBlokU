package org.ubdev.task.hashmap.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RearrangingFruitsTest {

    private RearrangingFruits solution;

    @BeforeEach
    public void setUp() {
        this.solution = new RearrangingFruits();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] basket1, int[] basket2, long expected) {
        // given

        // when
        long actual = solution.minCost(basket1, basket2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{4,2,2,2}, new int[]{1,4,1,2}, 1),
                Arguments.of(new int[]{2,3,4,1}, new int[]{3,2,5,1}, -1),
                Arguments.of(new int[]{84,80,43,8,80,88,43,14,100,88}, new int[]{32,32,42,68,68,100,42,84,14,8}, 48)
        );
    }
}