package BasicSyntax;

import java.math.BigInteger;

public class BasicSyntax {
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return (a ^ b && c ^ d) || (a ^ c && b ^ d);
    }

    public static int leapYearCount(int year) {
        return year / 4 - year / 100 + year / 400;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 0.0001;
    }

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }

    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value    any number
     * @param bitIndex index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << --bitIndex);
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        int x = Math.abs(value);
        return (x != 0) && ((x & (x - 1)) == 0);
    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        String formattingText = text.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder(formattingText);
        sb.reverse();
        return sb.toString().equalsIgnoreCase(formattingText);
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger res = BigInteger.ONE;
        for (int i = value; i > 1; i--) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];
        int curElemAtFirstArr = 0, curElemAtSecondArr = 0;

        while (curElemAtFirstArr < a1.length && curElemAtSecondArr < a2.length) {
            if (a1[curElemAtFirstArr] < a2[curElemAtSecondArr]) {
                res[curElemAtFirstArr + curElemAtSecondArr] = a1[curElemAtFirstArr];
                curElemAtFirstArr++;
            } else {
                res[curElemAtFirstArr + curElemAtSecondArr] = a2[curElemAtSecondArr];
                curElemAtSecondArr++;
            }
        }
        if (curElemAtFirstArr >= a1.length) {
            for (int i = curElemAtSecondArr; i < a2.length; i++) {
                res[curElemAtFirstArr + i] = a2[i];
            }
        } else {
            for (int i = curElemAtFirstArr; i < a1.length; i++) {
                res[curElemAtSecondArr + i] = a1[i];
            }
        }
        return res;
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sb = new StringBuilder("");
        for (String role : roles) {
            sb.append(role + ":\n");

            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].
                        startsWith(role + ":")
                ) {
                    sb.append((i + 1) + ")" +
                            textLines[i].
                                    substring(
                                            textLines[i].
                                                    indexOf(':') + 1
                                    ) + "\n");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}