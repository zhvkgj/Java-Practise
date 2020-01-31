package devide_and_rule;

import java.util.Arrays;
import java.util.Scanner;

public class CountSectors {
    private static int countSectors(int[] l, int[] r, int p) {
        return begBefore(l, p) - endAfter(r, p);
    }

    private static int begBefore(int[] arr, int p) {
        int left = -1;
        int right = arr.length;
        // a[left] <= x
        // a[right] > x
        while (left + 1 < right) {
            int middle = (right + left) >> 1;
            if (arr[middle] <= p) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left + 1;
    }

    private static int endAfter(int[] arr, int p) {
        int left = -1;
        int right = arr.length;
        // a[left] < x
        // a[right] >= x
        while (left + 1 < right) {
            int middle = (right + left) >> 1;
            if (arr[middle] < p) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] leftBounds = new int[n];
        int[] rightBounds = new int[n];
        int[] counts = new int[m];

        while (n > 0) {
            leftBounds[leftBounds.length - n] = scan.nextInt();
            rightBounds[rightBounds.length - n] = scan.nextInt();
            n--;
        }
        Arrays.sort(leftBounds);
        Arrays.sort(rightBounds);
        while (m > 0) {
            counts[counts.length - m] = countSectors(leftBounds, rightBounds, scan.nextInt());
            m--;
        }
        for (int c : counts){
            System.out.print(c + " ");
        }
    }
}
