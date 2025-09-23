package org.ubdev.task.tree.medium;

import org.junit.jupiter.api.Test;
import org.ubdev.task.tree.medium.DesignAddSearchWordsDataStructure.WordDictionary;

import static org.assertj.core.api.Assertions.assertThat;

class DesignAddSearchWordsDataStructureTest {

    @Test
    void tc1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        assertThat(wordDictionary.search("pad")).isFalse();
        assertThat(wordDictionary.search("bad")).isTrue();
        assertThat(wordDictionary.search(".ad")).isTrue();
        assertThat(wordDictionary.search("b..")).isTrue();
    }

    @Test
    void tc2() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");

        assertThat(wordDictionary.search("a")).isFalse();
        assertThat(wordDictionary.search(".at")).isFalse();

        wordDictionary.addWord("bat");

        assertThat(wordDictionary.search(".at")).isTrue();
        assertThat(wordDictionary.search("an.")).isTrue();
        assertThat(wordDictionary.search("a.d.")).isFalse();
        assertThat(wordDictionary.search("b.")).isFalse();
        assertThat(wordDictionary.search("a.d")).isTrue();
        assertThat(wordDictionary.search(".")).isFalse();
    }
}