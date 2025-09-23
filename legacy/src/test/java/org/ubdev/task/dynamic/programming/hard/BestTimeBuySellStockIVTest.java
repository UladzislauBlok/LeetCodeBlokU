package org.ubdev.task.dynamic.programming.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BestTimeBuySellStockIVTest {

    private BestTimeBuySellStockIV solution;

    @BeforeEach
    public void setUp() {
        this.solution = new BestTimeBuySellStockIV();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int k, int[] prices, int expected) {
        // given

        // when
        int actual = solution.maxProfit(k, prices);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(2, new int[]{2,4,1}, 2),
                Arguments.of(2, new int[]{3,2,6,5,0,3}, 7)
        );
    }
}