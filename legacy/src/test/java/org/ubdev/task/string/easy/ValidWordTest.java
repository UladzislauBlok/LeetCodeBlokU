package org.ubdev.task.string.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidWordTest {

    private ValidWord solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ValidWord();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String input, boolean expected) {
        // given

        // when
        boolean actual = solution.isValid(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("234Adas", true),
                Arguments.of("b3", false),
                Arguments.of("a3$e", false)
        );
    }
}