package org.ubdev.task.trie.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WordSearchIITest {

    private WordSearchII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new WordSearchII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(char[][] board, String[] words, List<String> expected) {
        // given

        // when
        List<String> actual = solution.findWords(board, words);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                        new String[]{"oath","pea","eat","rain"}, List.of("eat", "oath"))
        );
    }
}