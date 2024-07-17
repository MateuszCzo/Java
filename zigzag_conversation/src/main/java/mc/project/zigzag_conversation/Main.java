package mc.project.zigzag_conversation;

public class Main {
    public static void main(String[] args) {
//         3 a   1;
//           b c;
//           d;
//         4 a
//           b
//           d
//           c
//           e

        String s = "ABCDE";
        int numRows = 4;

        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder result = new StringBuilder();

        int jump = (numRows - 2) * 2 + 2;

        copyFirstRow(s, numRows, jump, result);
        copyMiddleRows(s, numRows, jump, result);
        copyLastRow(s, numRows, jump, result);
        
        return result.toString();
    }

    protected static void copyFirstRow(String s, int numRows, int jump, StringBuilder result) {
        for (int i = 0; i < s.length(); i += jump) {
            result.append(s.charAt(i));
        }
    }

    protected static void copyMiddleRows(String s, int numRows, int jump, StringBuilder result) {
        if (jump < 2) {
            return;
        }

        int numMiddleRows = numRows - 2;

        for (int i = 0; i < numMiddleRows; i++) {
            for (int j = 0; j < s.length() + numMiddleRows; j += jump) {
                int left = j - 1 - i, right = j + 1 + i;
                if (left > 0 && left < s.length()) result.append(s.charAt(left));
                if (right < s.length()) result.append(s.charAt(right));
            }
        }
    }

    protected static void copyLastRow(String s, int numRows, int jump, StringBuilder result) {
        for (int i = numRows - 1; i < s.length(); i += jump) {
            result.append(s.charAt(i));
        }
    }
}
