import java.util.HashSet;
import java.util.Set;

public class Main {
//    Given an array arr of integers, check if there exist two indices i and j such that :
//
//i != j
//0 <= i, j < arr.length
//arr[i] == 2 * arr[j]
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : arr) {
            if (num == 0 && numbers.contains(num)) {
                return true;
            }
            numbers.add(num);
        }
        for (int num : arr) {
            if (num != 0 && numbers.contains(num * 2)) {
                return true;
            }
        }
        return false;
    }
}