package mc.project.number_of_one_bits;

public class Main {
    public static void main(String[] args) {

    }
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >> 1;
        }
        return result;
    }
}
