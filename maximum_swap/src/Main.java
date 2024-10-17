import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(maximumSwap(98276));
    }

    public static int maximumSwap(int num) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toString(num));
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < stringBuilder.length(); i++) {
            indexMap.put((int)stringBuilder.charAt(i) - 48, i);
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            int number = stringBuilder.charAt(i) - 48;
            for (int j = 9; j > number; j--) {
                if (indexMap.containsKey(j) && indexMap.get(j) > i) {
                    swap(stringBuilder, i, indexMap.get(j));
                    return Integer.parseInt(stringBuilder.toString());
                }
            }
        }
        return num;
    }

    private static void swap(StringBuilder stringBuilder, int i, int j) {
        char temp = stringBuilder.charAt(i);
        stringBuilder.setCharAt(i, stringBuilder.charAt(j));
        stringBuilder.setCharAt(j, temp);
    }
}