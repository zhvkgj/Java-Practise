package devide_and_rule;

import java.util.*;

public class Inversions {
    private static long countOfInversions;

    private static int[] countOfInversions(int[] numbers, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            return mergeCount(countOfInversions(numbers, leftIndex, middleIndex),
                    countOfInversions(numbers, middleIndex + 1, rightIndex));
        }
        return new int[]{numbers[leftIndex]};
    }

    private static int[] mergeCount(int[] leftArr, int[] rightArr) {
        int leftHead = 0;
        int rightHead = 0;
        int[] result = new int[leftArr.length + rightArr.length];

        while (leftHead < leftArr.length && rightHead < rightArr.length) {
            if (leftArr[leftHead] > rightArr[rightHead]) {
                result[leftHead + rightHead] = rightArr[rightHead];
                rightHead++;
                countOfInversions += leftArr.length - leftHead;
            } else {
                result[leftHead + rightHead] = leftArr[leftHead];
                leftHead++;
            }
        }
        while (leftHead < leftArr.length) {
            result[leftHead + rightHead] = leftArr[leftHead];
            leftHead++;
        }
        while (rightHead < rightArr.length) {
            result[leftHead + rightHead] = rightArr[rightHead];
            rightHead++;
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
        countOfInversions(numbers, 0, numbers.length - 1);
        System.out.println(countOfInversions);
    }
}
