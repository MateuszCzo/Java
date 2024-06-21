package mc.project.find_the_index_of_the_first_occurrence_in_a_string;
/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Main {
    public static void main(String[] args) {

    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) {
                return -1;
            }
            if (haystack.charAt(i) == needle.charAt(0) &&
                    isRestTheSame(haystack, i, needle)) {
                return i;
            }
        }
        return -1;
    }

    protected static boolean isRestTheSame(String haystack, int start, String needle) {
        for (int i = 1; i < needle.length(); i++) {
            if (haystack.charAt(start + i) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
