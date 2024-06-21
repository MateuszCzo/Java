package mc.project.longest_palindromic_substring;

public class Main {
    public static void main(String[] args) {
        longestPalindrome("aacabdkacaa");
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {
                int newLength = right - left + 1;
                if (newLength > length) {
                    length = newLength;
                    start = left;
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {
                int newLength = right - left + 1;
                if (newLength > length) {
                    length = newLength;
                    start = left;
                }
                left--;
                right++;
            }
        }

        return s.substring(start, start + length);
    }
}
