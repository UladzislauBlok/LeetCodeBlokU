package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HIndexTest {

    private HIndex solution;

    @BeforeEach
    public void setUp() {
        this.solution = new HIndex();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] citations, int expected) {
        // given

        // when
        int actual = solution.hIndex(citations);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{3,0,6,1,5}, 3),
                Arguments.of(new int[]{1,3,1}, 1)
        );
    }
}