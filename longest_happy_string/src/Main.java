import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {
//    A string s is called happy if it satisfies the following conditions:
//
//s only contains the letters 'a', 'b', and 'c'.
//s does not contain any of "aaa", "bbb", or "ccc" as a substring.
//s contains at most a occurrences of the letter 'a'.
//s contains at most b occurrences of the letter 'b'.
//s contains at most c occurrences of the letter 'c'.
//Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".
//
//A substring is a contiguous sequence of characters within a string.
    public static void main(String[] args) {

    }

    public String longestDiverseString(int a, int b, int c) {
        int allowedRepeats = 2;
        int[] numbers = {a, b, c};
        char[] characters = {'a', 'b', 'c'};
        int sum = IntStream.of(numbers).sum();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sum; i++) {
            // get the biggest char
            int biggestNumIndex = IntStream.range(0, numbers.length)
                    .boxed()
                    .max(Comparator.comparingInt(j -> numbers[j]))
                    .orElse(-1);

            // if it's smaller or equal to 0 - break
            if (numbers[biggestNumIndex] <= 0) break;

            // check for repetition "aaa", "bbb", "ccc"...
            if (i >= 2 && checkRepetition(stringBuilder, i - 1, characters[biggestNumIndex], allowedRepeats)) {
                // true - add second-biggest char (if not 0 else break)
                int prevBiggestNumIndex = biggestNumIndex;
                biggestNumIndex = IntStream.range(0, numbers.length)
                        .filter(j -> j != prevBiggestNumIndex)
                        .boxed()
                        .max(Comparator.comparingInt(k -> numbers[k]))
                        .orElse(-1);

                if (numbers[biggestNumIndex] <= 0) break;
            }

            // add character to string and update number of characters
            stringBuilder.append(characters[biggestNumIndex]);
            numbers[biggestNumIndex]--;
        }

        return stringBuilder.toString();
    }

    private static boolean checkRepetition(StringBuilder stringBuilder, int start,
                                           char character, int numberOfChars) {
        int end = start - numberOfChars;
        for (int i = start; i > end; i--) {
            if (stringBuilder.charAt(i) != character) return false;
        }
        return true;
    }
}