package org.ubdev.task.bit.manipulation.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Number1BitsTest {

    private Number1Bits solution;

    @BeforeEach
    public void setUp() {
        this.solution = new Number1Bits();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int expected) {
        // given

        // when
        int actual = solution.hammingWeight(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(11, 3),
                Arguments.of(128, 1),
                Arguments.of(2147483645, 30)
        );
    }
}