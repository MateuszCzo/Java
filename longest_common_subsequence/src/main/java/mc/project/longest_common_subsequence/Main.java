package mc.project.longest_common_subsequence;

public class Main {
    public static int[][] cache;
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        cache = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return longestCommSubSeqLength(text1, 0, text2, 0);
    }
    public static int longestCommSubSeqLength(String text1, int start1,
                                       String text2, int start2) {
        if (text1.length() <= start1 || text2.length() <= start2) {
            return 0;
        }
        if (cache[start1][start2] != -1) {
            return cache[start1][start2];
        }
        int result;
        if (text1.charAt(start1) == text2.charAt(start2)) {
            result = longestCommSubSeqLength(text1, start1 + 1, text2, start2 + 1) + 1;
        } else {
            result = Math.max(
                    longestCommSubSeqLength(text1, start1 + 1, text2, start2),
                    longestCommSubSeqLength(text1, start1, text2, start2 + 1)
            );
        }
        cache[start1][start2] = result;
        return result;
    }

    public static int longestCommSubSeqLength2(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
