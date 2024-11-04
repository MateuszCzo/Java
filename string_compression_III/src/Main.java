public class Main {
//    Given a string word, compress it using the following algorithm:
//
//Begin with an empty string comp. While word is not empty, use the following operation:
//Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
//Append the length of the prefix followed by c to comp.
//Return the string comp.
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public String compressedString(String word) {
        StringBuilder result = new StringBuilder();
        char previousChar = word.charAt(0);
        int charCount = 1;
        for (int i = 1; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (currentChar == previousChar) {
                charCount++;
                if (charCount == 10) {
                    result.append(9).append(previousChar);
                    charCount = 1;
                }
            } else {
                result.append(charCount).append(previousChar);
                previousChar = currentChar;
                charCount = 1;
            }
        }
        result.append(charCount).append(previousChar);
        return result.toString();
    }
}