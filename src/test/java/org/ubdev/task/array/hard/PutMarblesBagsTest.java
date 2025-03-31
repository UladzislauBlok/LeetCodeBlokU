package org.ubdev.task.array.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PutMarblesBagsTest {

    private PutMarblesBags solution;

    @BeforeEach
    public void setUp() {
        this.solution = new PutMarblesBags();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] weights, int k, long expected) {
        // given

        // when
        long actual = solution.putMarbles(weights, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,3,5,1}, 2, 4),
                Arguments.of(new int[]{1, 3}, 2, 0)
        );
    }
}