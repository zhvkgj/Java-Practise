package devide_and_rule;

import java.util.Scanner;

public class CountSort {
    private static int[] countSort(int[] numbers) {
        final int M = 10;
        int[] countsArr = new int[M];
        int[] result = new int[numbers.length];
        for (int num : numbers) {
            countsArr[num - 1]++;
        }
        for (int i = 1; i < M; i++) {
            countsArr[i] += countsArr[i - 1];
        }
        for (int i = numbers.length; i > 0; i--) {
            int currentNum = numbers[i - 1];
            int rightBound = countsArr[currentNum - 1] - 1;
            countsArr[currentNum - 1]--;
            result[rightBound] = currentNum;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int[] numbers = new int[count];
        while (count > 0) {
            int current = scan.nextInt();
            numbers[numbers.length - count] = current;
            count--;
        }
        int[] result = countSort(numbers);
        for (int num : result) {
            System.out.println(num + " ");
        }
    }
}
