import java.util.ArrayList;
import java.util.List;

public class Main {
//    You are given two integers n and x. You have to construct an array of positive integers nums of size n where for every 0 <= i < n - 1, nums[i + 1] is greater than nums[i], and the result of the bitwise AND operation between all elements of nums is x.
//
//    Return the minimum possible value of nums[n - 1].
    public static void main(String[] args) {
        System.out.println(minEnd(2, 7));
    }

    public static long minEnd(int n, int x) {
        if (n == 1) {
            return x;
        }

        List<Integer> zeroPositions = new ArrayList<>();
        int count = 0;
        int value = x;
        while (value > 0) {
            if ((value & 1) == 0) {
                zeroPositions.add(count);
            }
            count++;
            value>>=1;
        }

        int requiredBits = (int)Math.ceil(Math.log(n) / Math.log(2));

        for (int i = zeroPositions.size(); i < requiredBits; i++) {
            zeroPositions.add(count++);
        }

        List<Integer> appendBits = getBinary(n - 1);

        long result = x;
        int position = appendBits.size() - 1;
        while (position >= 0) {
            if (appendBits.get(position) == 1) {
                result += (1L << zeroPositions.get(position));
            }
            position--;
        }

        return result;
    }

    private static List<Integer> getBinary(int n) {
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            if ((n & 1) == 1) {
                result.add(1);
            } else {
                result.add(0);
            }
            n >>= 1;
        }
        return result;
    }
}