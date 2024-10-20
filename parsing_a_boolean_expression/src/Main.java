import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> logics = new Stack<>(); // ! & |
        Stack<Character> values = new Stack<>(); // ( t f )

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == ',') {
                continue;
            }
            if (character == '!' || character == '|' || character == '&') {
                logics.push(character);
                continue;
            }
            if (character == ')') {
                parseSubExpression(logics, values);
                continue;
            }
            values.push(character);
        }

        return values.pop() == 't';
    }

    private static void parseSubExpression(Stack<Character> logics,
                                           Stack<Character> values) {
        char logic = logics.pop();
        boolean response;
        if (logic == '!') {
            response = !(values.pop() == 't');
        } else {
            response = values.pop() == 't';
        }
        char value = values.pop();
        while(value != '(') {
            if (logic == '|') {
                response |= value == 't';
            } else if (logic == '&'){
                response &= value == 't';
            }
            value = values.pop();
        }
        values.push((response ? 't' : 'f'));
    }
}