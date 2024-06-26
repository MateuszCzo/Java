package mc.project.palidromic_substrings;

public class Main {
    public static void main(String[] args) {

    }
    public static int countSubstrings(String s) {
        // O(n^2)
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += countOutwards(s, i, i);
            result += countOutwards(s, i, i + 1);
        }
        return result;
    }

    public static int countOutwards(String s, int left, int right) {
        int result = 0;
        while(left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            result++;
        }
        return result;
    }
}
