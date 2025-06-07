package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LexicographicallyMinimumStringAfterRemovingStarsTest {

    private LexicographicallyMinimumStringAfterRemovingStars solution;

    @BeforeEach
    public void setUp() {
        this.solution = new LexicographicallyMinimumStringAfterRemovingStars();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String s, String expected) {
        // given

        // when
        String actual = solution.clearStars(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("aaba*", "aab"),
                Arguments.of("abc", "abc")
        );
    }
}