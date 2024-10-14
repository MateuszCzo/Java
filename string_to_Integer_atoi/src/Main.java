public class Main {
//    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
//
//The algorithm for myAtoi(string s) is as follows:
//
//Whitespace: Ignore any leading whitespace (" ").
//Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
//Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
//Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
//Return the integer as the final result.
    public static void main(String[] args) {
        String s = "-91283472332";

        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        int length = s.length();
        int sign = 1;
        long result = 0;

        if (length == 0) {
            return 0;
        }

        int i = 0;
        while(i < length && s.charAt(i) == ' ') {
            i++;
        }
        if (i == length) {
            return 0;
        }
        if(s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if(s.charAt(i) == '+') {
            i++;
        }
        while(i < length) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return (int)(sign * result);
            }
            result = result * 10 + s.charAt(i) - 48;
            i++;
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)(sign * result);
    }
}