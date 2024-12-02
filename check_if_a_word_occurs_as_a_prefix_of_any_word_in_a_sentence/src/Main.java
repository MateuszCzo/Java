
public class Main {
//    Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.
//
//Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
//
//A prefix of a string s is any leading contiguous substring of s.
    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burger", "i love eating burger"));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        int wordCount = 1;

        if (samePrefix(sentence, 0, searchWord)) {
            return wordCount;
        }

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                wordCount++;
                if (samePrefix(sentence, i + 1, searchWord)) {
                    return wordCount;
                }
            }
        }

        return -1;
    }

    private static boolean samePrefix(String sentence, int start, String searchWord) {
        int searchIndex = 0;
        for (int i = start; i < sentence.length(); i++) {
            if (sentence.charAt(i) == searchWord.charAt(searchIndex)) {
                searchIndex++;
                if (searchIndex == searchWord.length()) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}