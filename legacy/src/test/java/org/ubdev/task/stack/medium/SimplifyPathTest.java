package org.ubdev.task.stack.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SimplifyPathTest {

    private SimplifyPath solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SimplifyPath();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String path, String expected) {
        // given

        // when
        String actual = solution.simplifyPath(path);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("/home/", "/home"),
                Arguments.of("/home//foo/", "/home/foo"),
                Arguments.of("/home/user/Documents/../Pictures", "/home/user/Pictures"),
                Arguments.of("/../", "/"),
                Arguments.of("/.../a/../b/c/../d/./", "/.../b/d")
        );
    }
}