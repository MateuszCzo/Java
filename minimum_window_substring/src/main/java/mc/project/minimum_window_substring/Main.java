package mc.project.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }
    public static String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) return "";

        Map<Character, Integer> searchLetters = new HashMap<>();
        int minLeft = 0;
        int minRight = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            searchLetters.put(key, searchLetters.getOrDefault(key, 0) + 1);
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);

            if (searchLetters.containsKey(key)) {
                int characterAmount = searchLetters.get(key) - 1;
                searchLetters.put(key, characterAmount);

                left = shiftLeftPointer(s, searchLetters, left);

                if (isWindowValid(searchLetters) && right - left < minRight - minLeft) {
                    minLeft = left;
                    minRight = right;
                }
            }
        }

        if (minRight == Integer.MAX_VALUE) return "";

        return s.substring(minLeft, minRight + 1);
    }

    protected static boolean isWindowValid(Map<Character, Integer> searchLetters) {
        for (int lettersAmount : searchLetters.values()) {
            if (lettersAmount > 0) {
                return false;
            }
        }
        return true;
    }

    protected static int shiftLeftPointer(String s, Map<Character, Integer> searchLetters, int left) {
        while (true) {
            char key = s.charAt(left);
            if (!searchLetters.containsKey(key)) {
                left++;
            } else {
                int amount = searchLetters.get(key);
                if(amount < 0) {
                    left++;
                    searchLetters.put(key, amount + 1);
                } else {
                    break;
                }
            }
        }
        return left;
    }
}
