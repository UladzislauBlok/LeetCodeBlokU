package org.ubdev.task.two.pointer.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidPalindromeTest {

    private ValidPalindrome solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ValidPalindrome();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String input, boolean expected) {
        // given

        // when
        boolean actual = solution.isPalindrome(input);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("",  true),
                Arguments.of(".,",  true),
                Arguments.of("ab_a",  true),
                Arguments.of("A man, a plan, a canal: Panama",  true),
                Arguments.of("race a car",  false),
                Arguments.of(" ",  true)
        );
    }
}