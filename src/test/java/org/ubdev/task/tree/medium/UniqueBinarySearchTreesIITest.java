package org.ubdev.task.tree.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.ubdev.domain.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.ubdev.util.TreeUtil.buildTreeNode;

class UniqueBinarySearchTreesIITest {

    private UniqueBinarySearchTreesII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new UniqueBinarySearchTreesII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, List<TreeNode> expected) {
        // given

        // when
        List<TreeNode> actual = solution.generateTrees(n);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(3, List.of(buildTreeNode(List.of(1, -1, 3, -1, -1, 2, -1)), buildTreeNode(List.of(1, -1, 2, -1, -1, -1, 3)),
                        buildTreeNode(List.of(2, 1, 3)), buildTreeNode(List.of(3, 2, -1, 1, -1, -1, -1)), buildTreeNode(List.of(3, 1, -1, -1, 2, -1, -1))))
        );
    }
}