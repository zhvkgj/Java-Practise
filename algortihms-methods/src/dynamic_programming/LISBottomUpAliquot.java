package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LISBottomUpAliquot {
    private void run() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        int n = scan.nextInt();
        int[] input = new int[n];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scan.nextInt();
            output[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            output[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[i] % input[j] == 0 && output[j] + 1 > output[i]) {
                    output[i] = output[j] + 1;
                }
            }
        }
        int result = 0;
        for (int num:
             output) {
            result = Math.max(result, num);
        }
        System.out.println(result);
    }
    public static void main(String[] args) throws FileNotFoundException{
        long startTime = System.currentTimeMillis();
        new LISBottomUpAliquot().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
