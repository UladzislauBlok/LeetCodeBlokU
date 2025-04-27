package org.ubdev.task.array.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CandyTest {

    private Candy solution;

    @BeforeEach
    public void setUp() {
        this.solution = new Candy();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] ratings, int expected) {
        // given

        // when
        int actual = solution.candy(ratings);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,3,4,5,2}, 11),
                Arguments.of(new int[]{1,0,2}, 5),
                Arguments.of(new int[]{1,2,2}, 4)
        );
    }
}