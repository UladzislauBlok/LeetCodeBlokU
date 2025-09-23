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

class MinimumAbsoluteDifferenceBSTTest {

    private MinimumAbsoluteDifferenceBST solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumAbsoluteDifferenceBST();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(TreeNode root, int expected) {
        // given

        // when
        int actual = solution.getMinimumDifference(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(buildTreeNode(List.of(4,2,6,1,3)), 1),
                Arguments.of(buildTreeNode(List.of(1,0,48,-1,-1,12,49)), 1)
        );
    }
}