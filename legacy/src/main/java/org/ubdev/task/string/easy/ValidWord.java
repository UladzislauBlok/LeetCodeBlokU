package org.ubdev.task.string.easy;

import java.util.Set;

class ValidWord {

    private static final Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
    private static final Set<Character> garbage = Set.of('@', '#', '$');

    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        boolean digit = false, vowel = false, consonant = false;
        for (char c : word.toCharArray()) {
            if (garbage.contains(c))
                return false;
            else if (vowels.contains(c))
                vowel = true;
            else if (!Character.isDigit(c))
                consonant = true;
        }
        return vowel && consonant;
    }
}
