package mc.project.counting_bits;

public class Main {
    public static void main(String[] args) {
        countBits(5);
    }
    public static int[] countBits(int n) {
        int length = n + 1;
        int[] result = new int[length];
        result[0] = 0;

        int currentPowerOfTwo = 0;
        int nextPowerOfTwo = 1;

        for (int i = 1; i < length; i++) {
            if (i == nextPowerOfTwo) {
                currentPowerOfTwo  = nextPowerOfTwo;
                nextPowerOfTwo *= 2;
                result[i] = 1;
                continue;
            }
            result[i] = 1 + result[i - currentPowerOfTwo];
        }
        return result;
    }
}
