package org.ubdev.task.stack.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluateReversePolishNotationTest {

    private EvaluateReversePolishNotation solution;

    @BeforeEach
    public void setUp() {
        this.solution = new EvaluateReversePolishNotation();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String[] tokens, int expected) {
        // given

        // when
        int actual = solution.evalRPN(tokens);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new String[]{"2","1","+","3","*"}, 9),
                Arguments.of(new String[]{"4","13","5","/","+"}, 6),
                Arguments.of(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}, 22)
        );
    }
}