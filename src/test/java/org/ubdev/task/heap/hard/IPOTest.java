package org.ubdev.task.heap.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IPOTest {

    private IPO solution;

    @BeforeEach
    public void setUp() {
        this.solution = new IPO();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int k, int w, int[] profits, int[] capitals, int expected) {
        // given

        // when
        int actual = solution.findMaximizedCapital(k, w, profits, capitals);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(2, 0, new int[]{1,2,3}, new int[]{0,1,1}, 4),
                Arguments.of(3, 0, new int[]{1,2,3}, new int[]{0,1,2}, 6)
        );
    }
}