package mc.project.sum_of_two_integers;

import java.nio.ByteBuffer;

/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */
public class Main {
    public static void main(String[] args) {
        int a = 1234;
        int b = 5678;
        int result = add(a, b);

        System.out.println("Liczba a: " + a);
        System.out.println("Liczba b: " + b);
        System.out.println("Suma: " + result);
    }

    public static int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
