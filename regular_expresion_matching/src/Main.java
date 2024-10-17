//Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
//
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
//The matching should cover the entire input string (not partial).
//
//
//
//Example 1:
//
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
//Example 2:
//
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//Example 3:
//
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
//
//
//Constraints:
//
//1 <= s.length <= 20
//1 <= p.length <= 20
//s contains only lowercase English letters.
//p contains only lowercase English letters, '.', and '*'.
//It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] result = new boolean[sLength + 1][pLength + 1];
        result[0][0] = true;

        for (int i = 1; i <= pLength; i++) {
            if (p.charAt(i - 1) == '*') {
                result[0][i] = result[0][i - 2];
            }
        }

        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    result[i][j] = result[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        result[i][j] = result[i][j] || result[i - 1][j];
                    }
                } else {
                    result[i][j] = false;
                }
            }
        }
        
        return result[sLength][pLength];
    }
}