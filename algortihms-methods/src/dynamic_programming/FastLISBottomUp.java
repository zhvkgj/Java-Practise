package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FastLISBottomUp {
    private void run() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        int n = scan.nextInt();
        int[] input = new int[n];
        int[] output = new int[n];
        int[] prev = new int[n];
        int[] curr = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scan.nextInt();
            output[i] = -1;
        }
        output[0] = input[0];
        curr[0] = 0;
        int size = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearch(output, input[i], size);
            output[index] = input[i];
            curr[index] = i;
            if (index != 0)
                prev[i] = curr[index - 1];
            if (index == size) {
                size++;
            }
        }
        System.out.println(size);
        output[size - 1] = curr[size - 1];
        for (int i = 1; i < size; i++) {
            output[size - i - 1] = prev[output[size - i]];
        }
        for (int i = 0; i < size; i++) {
            System.out.print(output[i] + 1 + " ");
        }
        System.out.println();
    }

    private static int binarySearch(int[] arr, int p, int r) {
        int left = -1;
        int right = r;
        // a[left] <= x
        // a[right] > x
        while (left + 1 < right) {
            int middle = (right + left) >> 1;
            if (arr[middle] >= p) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new FastLISBottomUp().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
