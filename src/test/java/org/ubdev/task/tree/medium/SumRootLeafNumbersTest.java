package org.ubdev.task.tree.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.ubdev.domain.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.ubdev.util.TreeUtil.buildTreeNode;

class SumRootLeafNumbersTest {

    private SumRootLeafNumbers solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SumRootLeafNumbers();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(TreeNode root, int expected) {
        // given

        // when
        int actual = solution.sumNumbers(root);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(buildTreeNode(List.of(1,2,3)), 25),
                Arguments.of(buildTreeNode(List.of(4,9,0,5,1)), 1026)
        );
    }
}