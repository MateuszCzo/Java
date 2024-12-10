import java.util.Arrays;

public class Main {
//    You are given a string s that consists of lowercase English letters.
//
//A string is called special if it is made up of only a single character. For example, the string "abc" is not special, whereas the strings "ddd", "zz", and "f" are special.
//
//Return the length of the longest special substring of s which occurs at least thrice, or -1 if no special substring occurs at least thrice.
//
//A substring is a contiguous non-empty sequence of characters within a string.
    public static void main(String[] args) {
        System.out.println(maximumLength("abcdeffaa"));
    }

    public static int maximumLength(String s) {
        int[][] top3Frequency = new int[26][3];

        char prevChar = ' ';
        int windowLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int currIndex = currChar - 'a';
            windowLength = (currChar == prevChar) ? windowLength + 1 : 1;
            prevChar = currChar;

            int minIndex = 0;
            for (int j = 1; j < 3; j++) {
                if (top3Frequency[currIndex][j] < top3Frequency[currIndex][minIndex]) {
                    minIndex = j;
                }
            }

            if (windowLength > top3Frequency[currIndex][minIndex]) {
                top3Frequency[currIndex][minIndex] = windowLength;
            }
        }

        int maxLength = 0;
        for (int i = 0; i < top3Frequency.length; i++) {
            int minLength = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (top3Frequency[i][j] < minLength) {
                    minLength = top3Frequency[i][j];
                }
            }
            maxLength = Math.max(maxLength, minLength);
        }

        return maxLength != 0 ? maxLength : -1;
    }
}