package org.ubdev.task.math.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeNumberTest {

    private PalindromeNumber solution;

    @BeforeEach
    public void setUp() {
        this.solution = new PalindromeNumber();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int x, boolean expected) {
        // given

        // when
        boolean actual = solution.isPalindrome(x);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false)
        );
    }
}