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

class HouseRobberIIITest {

    private HouseRobberIII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new HouseRobberIII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(TreeNode root, int expected) {
        // given

        // when
        int actual = solution.rob(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(buildTreeNode(List.of(3,2,3,-1,3,1,-1)), 7),
                Arguments.of(buildTreeNode(List.of(3,4,5,1,3,-1,1)), 9)
        );
    }
}