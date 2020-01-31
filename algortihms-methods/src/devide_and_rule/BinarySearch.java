package devide_and_rule;

import java.util.Scanner;

public class BinarySearch {
    private static int binarySearch(int number, int[] array) {
        int leftBound = 0;
        int rightBound = array.length - 1;
        int middle;
        while (leftBound <= rightBound) {
            middle = leftBound + (rightBound - leftBound) / 2;
            //System.out.println("l: " + leftBound + ", r: " + rightBound + ", middle: " + middle);
            if (number == array[middle]) {
                return middle + 1;
            }
            if (number < array[middle]) {
                rightBound = middle - 1;
            } else {
                leftBound = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lengthArr = scan.nextInt();
        int[] numbers = new int[lengthArr];
        while (lengthArr > 0) {
            numbers[numbers.length - lengthArr] = scan.nextInt();
            lengthArr--;
        }
        int countNum = scan.nextInt();
        int[] result = new int[countNum];
        int current;
        while (countNum > 0) {
            current = scan.nextInt();
            result[result.length - countNum] = binarySearch(current, numbers);
            countNum--;
        }
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
