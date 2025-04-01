package org.ubdev.task.tree.medium;

import org.junit.jupiter.api.Test;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.ubdev.util.TreeUtil.buildTreeNode;

class BSTIteratorTest {

    @Test
    void tc1() {
        BSTIterator bSTIterator = new BSTIterator(buildTreeNode(of(7, 3, 15, -1, -1, 9, 20)));

        assertThat(bSTIterator.next()).isEqualTo(3);    // return 3
        assertThat(bSTIterator.next()).isEqualTo(7);    // return 7
        assertThat(bSTIterator.hasNext()).isEqualTo(true); // return True
        assertThat(bSTIterator.next()).isEqualTo(9);    // return 9
        assertThat(bSTIterator.hasNext()).isEqualTo(true); // return True
        assertThat(bSTIterator.next()).isEqualTo(15);   // return 15
        assertThat(bSTIterator.hasNext()).isEqualTo(true); // return True
        assertThat(bSTIterator.next()).isEqualTo(20);   // return 20
        assertThat(bSTIterator.hasNext()).isEqualTo(false); // return False
    }
}