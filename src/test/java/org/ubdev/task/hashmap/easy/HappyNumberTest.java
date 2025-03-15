package org.ubdev.task.hashmap.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HappyNumberTest {

    private HappyNumber solution;

    @BeforeEach
    public void setUp() {
        this.solution = new HappyNumber();
    }

    @ParameterizedTest
    @MethodSource
    void isIsomorphicReturnsExpectedResult(int n, boolean expected) {
        // given

        // when
        boolean actual = solution.isHappy(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> isIsomorphicReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(19, true),
                Arguments.of(2, false)
        );
    }
}