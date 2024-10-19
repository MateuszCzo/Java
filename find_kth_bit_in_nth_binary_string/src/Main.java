public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public char findKthBit(int n, int k) {
        return generateBinaryString(n).charAt(k - 1);
    }

    private static StringBuilder generateBinaryString(int n) {
        if (n == 1) {
            return new StringBuilder("0");
        }

        StringBuilder stringBuilder = generateBinaryString(n - 1);

        StringBuilder response = new StringBuilder(stringBuilder);

        response.append('1');

        for (int i = 0; i < stringBuilder.length(); i++) {
            stringBuilder.replace(i, i + 1, stringBuilder.charAt(i) == '1' ? "0" : "1");
        }
        response.append(stringBuilder.reverse());

        return response;
    }

    private static char getKthCharacter(int n, int k) {
        if (n == 1) return '0';

        int length = 1 << n; // (2^n)

        if (length / 2 == k) return '1';

        if (k < length / 2) return getKthCharacter(n - 1, k);

        return getKthCharacter(n - 1, length - k) == '1' ? '0' : '1';
    }
}