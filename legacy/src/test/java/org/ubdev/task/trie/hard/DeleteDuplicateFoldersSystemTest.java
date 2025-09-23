package org.ubdev.task.trie.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteDuplicateFoldersSystemTest {

    private DeleteDuplicateFoldersSystem solution;

    @BeforeEach
    public void setUp() {
        this.solution = new DeleteDuplicateFoldersSystem();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(List<List<String>> paths, List<List<String>> expected) {
        // given

        // when
        List<List<String>> actual = solution.deleteDuplicateFolder(paths);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(List.of(List.of("a"), List.of("c"), List.of("d"), List.of("a", "b"), List.of("c", "b"), List.of("d", "a")),
                        List.of(List.of("d"), List.of("d", "a"))),
                Arguments.of(List.of(List.of("a"), List.of("c"), List.of("a", "b"), List.of("c", "b"), List.of("a", "b", "x"), List.of("a", "b", "x", "y"), List.of("w"), List.of("w", "y")),
                        List.of(List.of("c"), List.of("c", "b"), List.of("a"), List.of("a", "b"))),
                Arguments.of(List.of(List.of("a","b"),List.of("c","d"),List.of("c"),List.of("a")),
                        List.of(List.of("c"),List.of("c","d"),List.of("a"),List.of("a","b")))
                );
    }
}