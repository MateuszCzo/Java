package mc.project.word_break;

import java.util.LinkedList;
import java.util.List;
/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class Main {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");

        wordBreak2(s, wordDict);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        List<char[]> charDict = new LinkedList<>();
        for (String word : wordDict) {
            charDict.add(word.toCharArray());
        }
        char[] charS = s.toCharArray();

        for (char[] word : charDict) {
            if (startsWithAndContinue(word, charS, 0, charDict)) {
                return true;
            }
        }

        return false;
    }

    public static boolean startsWithAndContinue(char[] startsWith, char[] searchIn, int fromIndex, List<char[]> charDict) {
        for (int i = 0; i < startsWith.length; i++) {
            if (searchIn.length <= i + fromIndex || searchIn[i + fromIndex] != startsWith[i]) {
                return false;
            }
        }
        if (fromIndex + startsWith.length == searchIn.length) {
            return true;
        }
        for (char[] word : charDict) {
            if (startsWithAndContinue(word, searchIn, fromIndex + startsWith.length, charDict)) {
                return true;
            }
        }
        return false;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if (i - word.length() >= 0 && dp[i - word.length()] && s.startsWith(word, i - word.length()))  {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }


    int[] nums = {5,6,4,3,7,8,1,2,0};

    int[] minArrLength[] = {1, 1, 2,3,1,1,4,4,5};
}
