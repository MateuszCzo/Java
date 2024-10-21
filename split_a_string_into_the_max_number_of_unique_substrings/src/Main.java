import java.util.HashSet;
import java.util.Set;

public class Main {
//  Given a string s, return the maximum number of unique substrings that the given string can be split into.
//
//  You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.
//
//  A substring is a contiguous sequence of characters within a string.
    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("addbsd"));

        a d b s
    }


    public static int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private static int backtrack(String s, int start, Set<String> seen) {
        if (start >= s.length()) return 0;

        int result = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!seen.contains(substring)) {
                seen.add(substring);
                result = Math.max(result, 1 + backtrack(s, end, seen));
                seen.remove(substring);
            }
        }

        return result;
    }
}