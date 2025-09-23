package org.ubdev.task.bit.manipulation.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AddBinaryTest {

    private AddBinary solution;

    @BeforeEach
    public void setUp() {
        this.solution = new AddBinary();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String a, String b, String expected) {
        // given

        // when
        String actual = solution.addBinary(a, b);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("1", "111", "1000"),
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101")
        );
    }
}