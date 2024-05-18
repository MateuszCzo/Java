package mc.project.valid_anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class Main {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        long startTime = System.currentTimeMillis();

        boolean val2 = isAnagram3(s, t);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas wykonania: " + duration + " ms");
        System.out.println(val2);
    }

    public static boolean isAnagram(String s, String t) {
        int length = s.length();
        if (length != t.length()) return false;

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char character = s.charAt(i);
            charMap.put(character, charMap.getOrDefault(character, 0) + 1);
            char character2 = t.charAt(i);
            charMap.put(character2, charMap.getOrDefault(character2, 0) - 1);
        }
        for (int charNum : charMap.values()) {
            if (charNum != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static boolean isAnagram3(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (char character : s.toCharArray()) {
            charMap.put(character, charMap.getOrDefault(character, 0) + 1);
        }

        for (char character : t.toCharArray()) {
            charMap.put(character, charMap.getOrDefault(character, 0) - 1);
        }

        for (int charNum : charMap.values()) {
            if (charNum != 0) {
                return false;
            }
        }
        return true;
    }

}
