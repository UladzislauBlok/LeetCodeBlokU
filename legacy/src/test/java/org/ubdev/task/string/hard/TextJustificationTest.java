package org.ubdev.task.string.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TextJustificationTest {

    private TextJustification solution;

    @BeforeEach
    public void setUp() {
        this.solution = new TextJustification();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String[] words, int maxWidth, List<String> expected) {
        // given

        // when
        List<String> actual = solution.fullJustify(words, maxWidth);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16,
                        List.of("This    is    an",
                                "example  of text",
                                "justification.  "))
        );
    }
}