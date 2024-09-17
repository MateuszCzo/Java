

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();

        dfs(results, new StringBuilder(), 0, 0, n);

        return results;
    }

    public void dfs(List<String> results, StringBuilder result, int open, int close, int n) {
        if (open == n && close == n) {
            results.add(result.toString());
            return;
        }

        if (open < n) {
            result.append('(');
            dfs(results, result, open + 1, close, n);
            result.deleteCharAt(result.length() - 1);
        }

        if (close < open) {
            result.append(')');
            dfs(results, result, open, close + 1, n);
            result.deleteCharAt(result.length() - 1);
        }
    }
}