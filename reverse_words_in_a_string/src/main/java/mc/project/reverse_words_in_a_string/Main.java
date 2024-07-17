package mc.project.reverse_words_in_a_string;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static String reverseWords(String s) {
        List<int[]> wordsIndexes = new ArrayList<>();
        int i = 0, length = s.length();

        while (i < length) {
            while (i < length && s.charAt(i) == ' ') {
                i++;
            }
            if (i >= length) {
                break;
            }
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            int end = i - 1;
            wordsIndexes.add(new int[] {start, end});
        }

        StringBuilder result = new StringBuilder();

        for (int j = wordsIndexes.size() - 1; j >= 0; j--) {
            for (int k = wordsIndexes.get(j)[0], end = wordsIndexes.get(j)[1]; k <= end; k++) {
                result.append(s.charAt(k));
            }
            result.append(' ');
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }
}
