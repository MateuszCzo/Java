public class Main {

//      A fancy string is a string where no three consecutive characters are equal.
//
//      Given a string s, delete the minimum possible number of characters from s to make it fancy.
//
//      Return the final string after the deletion. It can be shown that the answer will always be unique.

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public String makeFancyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char lastChar = 'a';
        int charCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == lastChar) {
                if (charCount >= 2) {
                    continue;
                }
                charCount++;
            } else {
                lastChar = currentChar;
                charCount = 1;
            }
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
