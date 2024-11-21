import java.util.HashMap;
import java.util.Map;

public class Main {
//    You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.
//
//Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;

        int[] freq = new int[3];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)- 'a']++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] < k) return -1;
        }

        int[] curr = new int[3];
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            curr[s.charAt(right) - 'a']++;

            while (left <= right &&
                    (curr[0] > freq[0] - k ||
                     curr[1] > freq[1] - k ||
                     curr[2] > freq[2] - k)) {
                curr[s.charAt(left) - 'a']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return s.length() - maxLen;
    }
}