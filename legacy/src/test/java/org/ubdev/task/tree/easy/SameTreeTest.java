package org.ubdev.task.tree.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.ubdev.domain.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.ubdev.util.TreeUtil.buildTreeNode;

class SameTreeTest {

    private SameTree solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SameTree();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(TreeNode p, TreeNode q, boolean expected) {
        // given

        // when
        boolean actual = solution.isSameTree(p,q );

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(buildTreeNode(List.of(1,2,3)), buildTreeNode(List.of(1,2,3)), true),
                Arguments.of(buildTreeNode(List.of(1,2)), buildTreeNode(List.of(1,-1,2)), false),
                Arguments.of(buildTreeNode(List.of(1,2,1)), buildTreeNode(List.of(1,1,2)), false)
        );
    }
}