package org.ubdev.task.string.hard;

import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedText = new ArrayList<>();
        int index = 0;
        int numOfWords = words.length;

        while (index < numOfWords) {
            List<String> currentLineWords = new ArrayList<>();
            currentLineWords.add(words[index]);
            int currentLineWidth = words[index].length();
            index++;
            while (index < numOfWords && currentLineWidth + 1 + words[index].length() <= maxWidth) {
                currentLineWidth += 1 + words[index].length();
                currentLineWords.add(words[index++]);

            }
            if (index == numOfWords || currentLineWords.size() == 1) {
                String leftAlignedText = String.join(" ", currentLineWords);
                String rightPadding = " ".repeat(maxWidth - leftAlignedText.length());
                justifiedText.add(leftAlignedText + rightPadding);
                continue;
            }
            int totalSpaces = maxWidth - (currentLineWidth - currentLineWords.size() + 1);
            int spaceWidth = totalSpaces / (currentLineWords.size() - 1);
            int extraSpacesCount = totalSpaces % (currentLineWords.size() - 1);
            StringBuilder justifiedLine = new StringBuilder();
            for (int wordIndex = 0; wordIndex < currentLineWords.size() - 1; wordIndex++) {
                justifiedLine.append(currentLineWords.get(wordIndex));
                justifiedLine.append(" ".repeat(spaceWidth));
                if (wordIndex < extraSpacesCount) {
                    justifiedLine.append(" ");
                }
            }
            justifiedLine.append(currentLineWords.get(currentLineWords.size() - 1));
            justifiedText.add(justifiedLine.toString());
        }

        return justifiedText;
    }
}
