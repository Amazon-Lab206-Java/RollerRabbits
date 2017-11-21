public class StringManipulator {
    public String trimAndConcat(String word1, String word2) {
        String trimmed1 = word1.trim();
        String trimmed2 = word2.trim();
        String concat = trimmed1.concat(trimmed2);
        return concat;
    }

    public Integer getIndexOrNull(String word, char letter) {
        int indexOf = word.indexOf(letter);
        if (indexOf == -1)
            return null;
        else
            return indexOf;
    }

    public Integer getIndexOrNull(String wholeWord, String partialWord) {
        int indexOf = wholeWord.indexOf(partialWord);
        if (indexOf == -1)
            return null;
        else
            return indexOf;
    }

    public String concatSubstring(String word1, int start, int end, String word2) {
        String substring = word1.substring(start, end);
        return substring.concat(word2);
    }
}
