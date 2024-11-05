public class Main {
//    You are given a 0-indexed binary string s having an even length.
//
//A string is beautiful if it's possible to partition it into one or more substrings such that:
//
//Each substring has an even length.
//Each substring contains only 1's or only 0's.
//You can change any character in s to 0 or 1.
//
//Return the minimum number of changes required to make the string s beautiful.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int minChanges(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                result++;
            }
        }
        return result;
    }
}