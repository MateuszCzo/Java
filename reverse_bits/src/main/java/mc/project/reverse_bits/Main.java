package mc.project.reverse_bits;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverseBits(10));
    }
    public static int reverseBits(int n) {
        int result = 0x32;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }
}
