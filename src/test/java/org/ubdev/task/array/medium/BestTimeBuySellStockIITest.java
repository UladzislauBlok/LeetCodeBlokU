package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BestTimeBuySellStockIITest {

    private BestTimeBuySellStockII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new BestTimeBuySellStockII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] prices, int expected) {
        // given

        // when
        int actual = solution.maxProfit(prices);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{7,1,5,3,6,4}, 7),
                Arguments.of(new int[]{1,2,3,4,5}, 4),
                Arguments.of(new int[]{7,6,4,3,1}, 0)
        );
    }
}