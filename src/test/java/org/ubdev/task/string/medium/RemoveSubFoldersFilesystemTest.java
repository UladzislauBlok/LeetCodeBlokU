package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveSubFoldersFilesystemTest {

    private RemoveSubFoldersFilesystem solution;

    @BeforeEach
    public void setUp() {
        this.solution = new RemoveSubFoldersFilesystem();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String[] folders, List<String> expected) {
        // given

        // when
        List<String> actual = solution.removeSubfolders(folders);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}, List.of("/a","/c/d","/c/f")),
                Arguments.of(new String[]{"/a","/a/b/c","/a/b/d"}, List.of("/a")),
                Arguments.of(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}, List.of("/a/b/c","/a/b/ca","/a/b/d"))
        );
    }
}