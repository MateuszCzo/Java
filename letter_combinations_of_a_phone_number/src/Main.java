import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    17. Letter Combinations of a Phone Number
//    Medium
//            Topics
//    Companies
//    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

public class Main {
    public static void main(String[] args) {

    }

    private static final Map<Character, String> keyboard = new HashMap<>();
    static{
        keyboard.put('2', "abc");
        keyboard.put('3', "def");
        keyboard.put('4', "ghi");
        keyboard.put('5', "jkl");
        keyboard.put('6', "mno");
        keyboard.put('7', "pqrs");
        keyboard.put('8', "tuv");
        keyboard.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        generateResult(result, new StringBuilder(), digits, 0);

        return result;
    }

    private void generateResult(List<String> result, StringBuilder combination, String digits, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = keyboard.get(digit);

        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            generateResult(result, combination, digits, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}