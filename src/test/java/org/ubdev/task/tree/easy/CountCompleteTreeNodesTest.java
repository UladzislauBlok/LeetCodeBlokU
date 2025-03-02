package org.ubdev.task.tree.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.ubdev.domain.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.ubdev.util.TreeUtil.buildTreeNode;

class CountCompleteTreeNodesTest {

    private CountCompleteTreeNodes solution;

    @BeforeEach
    public void setUp() {
        this.solution = new CountCompleteTreeNodes();
    }

    @ParameterizedTest
    @MethodSource
    void countNodesReturnsExpectedResult(TreeNode input, int expected) {
        // given

        // when
        int actual = solution.countNodes(input);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> countNodesReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(buildTreeNode(List.of(1,2,3,4,5,6)), 6),
                Arguments.of(buildTreeNode(List.of()), 0),
                Arguments.of(buildTreeNode(List.of(1)), 1)
        );
    }
}