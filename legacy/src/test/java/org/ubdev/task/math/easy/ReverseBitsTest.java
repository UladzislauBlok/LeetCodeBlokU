package org.ubdev.task.math.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseBitsTest {

    private ReverseBits solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ReverseBits();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int input, int expected) {
        // given

        // when
        int actual = solution.reverseBits(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(-3, -1073741825)
        );
    }
}