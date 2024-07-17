package mc.project.length_of_last_word;

public class Main {
    public static void main(String[] args) {

    }

    public static int lengthOfLastWord(String s) {
        int lastIndex = s.length() - 1;
        while (s.charAt(lastIndex) == ' ') {
            lastIndex--;
        }
        int wordLastIndex = lastIndex;
        while (lastIndex >= 0 && s.charAt(lastIndex) != ' ') {
            lastIndex--;
        }
        return wordLastIndex - lastIndex;
    }
}
