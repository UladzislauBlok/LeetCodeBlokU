package org.ubdev.task.bit.manipulation.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PowerTwoTest {

    private PowerTwo solution;

    @BeforeEach
    public void setUp() {
        this.solution = new PowerTwo();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, boolean expected) {
        // given

        // when
        boolean actual = solution.isPowerOfTwo(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(16, true),
                Arguments.of(30, false),
                Arguments.of(0, false),
                Arguments.of(-1, false)
        );
    }
}