package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerRomanTest {

    private IntegerRoman solution;

    @BeforeEach
    public void setUp() {
        this.solution = new IntegerRoman();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int num, String expected) {
        // given

        // when
        String actual = solution.intToRoman(num);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(3749, "MMMDCCXLIX"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV")
        );
    }
}