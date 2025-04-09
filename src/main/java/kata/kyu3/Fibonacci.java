package kata.kyu3;

import java.math.BigInteger;

public class Fibonacci {
    private Fibonacci() {
    }
    public static BigInteger fib(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) return BigInteger.ZERO;

        if (n.equals(BigInteger.ONE)) return BigInteger.ONE;

        if (n.compareTo(BigInteger.ZERO) < 0) {
            BigInteger positiveN = n.negate();
            BigInteger result = fib(positiveN);
            // Applying the identity for negative Fibonacci indices
            return (positiveN.mod(BigInteger.TWO).equals(BigInteger.ZERO)) ? result.negate() : result;
        }


        // Base matrices for matrix exponentiation
        BigInteger[][] result = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};
        BigInteger[][] fibMatrix = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};

        powerMatrix(fibMatrix, n.subtract(BigInteger.ONE), result);

        return result[0][0];
    }
    private static void powerMatrix(BigInteger[][] matrix, BigInteger exp, BigInteger[][] result) {
        while (exp.compareTo(BigInteger.ZERO) > 0) {
            if (exp.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                multiplyMatrix(result, matrix);
            }
            multiplyMatrix(matrix, matrix);
            exp = exp.divide(BigInteger.TWO);
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
