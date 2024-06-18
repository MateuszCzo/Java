package mc.project.valid_palindrome;
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class Main {
    public static void main(String[] args) {
        IsPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean IsPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while(start <= end) {
            char startCharacter = s.charAt(start);
            char endCharacter = s.charAt(end);
            if (!Character.isLetterOrDigit(startCharacter)) {
                start++;
            } else if (!Character.isLetterOrDigit(endCharacter)) {
                end--;
            } else {
                if (Character.toLowerCase(startCharacter) != Character.toLowerCase(endCharacter)) {
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }
}
