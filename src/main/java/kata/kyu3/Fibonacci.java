package kata.kyu3;

import java.math.BigInteger;

public class Fibonacci {
    public static BigInteger fib(BigInteger n) {
        // check if n is 0 or 1
        if (n.intValue() <= 1)
            return n;

        BigInteger[][] result = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};
        BigInteger[][] fibMatrix = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        // use matrix exponentiation to calculate Fibonacci
        powerMatrix(fibMatrix, n.intValue() - 1, result);

        return result[0][0];
    }
    private static void powerMatrix(BigInteger[][] matrix, int exp, BigInteger[][] result) {
        while (exp > 0) {
            if (exp % 2 == 1) {
                multiplyMatrix(result, matrix);
            }
            multiplyMatrix(matrix, matrix);
            exp = exp / 2;
        }
    }
    private static void multiplyMatrix(BigInteger[][] a, BigInteger[][] b) {
        BigInteger x = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
        BigInteger y = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
        BigInteger z = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));
        BigInteger w = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));

        a[0][0] = x;
        a[0][1] = y;
        a[1][0] = z;
        a[1][1] = w;
    }
}
