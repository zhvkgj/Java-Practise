package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StairsSumBU {
    private void run() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        int n = scan.nextInt();
        int[] stairs = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = scan.nextInt();
        }
        int prevPrev = 0;
        int prev = stairs[0];
        if (n == 1) {
            System.out.println(prev + prevPrev);
            return;
        }
        int curr = 0;
        for (int i = 1; i < n; i++) {
            curr = stairs[i] + Math.max(prevPrev, prev);
            prevPrev = prev;
            prev = curr;
        }
        System.out.println(curr);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new StairsSumBU().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
