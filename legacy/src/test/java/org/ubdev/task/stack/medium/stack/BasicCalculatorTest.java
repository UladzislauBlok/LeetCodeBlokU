package org.ubdev.task.stack.medium.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BasicCalculatorTest {

    private BasicCalculator solution;

    @BeforeEach
    public void setUp() {
        this.solution = new BasicCalculator();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String input, int expected) {
        // given

        // when
        int actual = solution.calculate(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("1 + 1", 2),
                Arguments.of(" 2-1 + 2 ", 3),
                Arguments.of("(1+(4+5+2)-3)+(6+8)", 23)
        );
    }
}