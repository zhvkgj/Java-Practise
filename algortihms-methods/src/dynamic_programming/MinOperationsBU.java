package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinOperationsBU {
    private void run() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        int n = scan.nextInt();
        int[] minOp = new int[n];
        minOp[0] = 0;
        if (n == 1) {
            System.out.println(0 + "\n" + 1);
            return;
        }
        minOp[1] = 1;

        for (int i = 2; i < n; i++) {
            int m0 = Integer.MAX_VALUE;
            if ((i + 1) % 2 == 0) {
                m0 = minOp[(i + 1) / 2 - 1];
            }
            int m1 = Integer.MAX_VALUE;
            if ((i + 1) % 3 == 0) {
                m1 = minOp[(i + 1) / 3 - 1];
            }
            minOp[i] = Math.min(m0, Math.min(m1, minOp[i - 1])) + 1;
        }
        int[] steps = new int[minOp[n - 1] + 1];
        steps[0] = 1;
        int curr = n;
        while (curr > 1) {
            int curOpCount = minOp[curr - 1];
            steps[curOpCount] = curr;
            if (curOpCount - 1 == minOp[curr - 2]) {
                curr--;
                continue;
            }
            if (curr % 2 == 0 && curOpCount - 1 == minOp[curr / 2 - 1]) {
                curr = curr / 2;
                continue;
            }
            if (curr % 3 == 0 && curOpCount - 1 == minOp[curr / 3 - 1]) {
                curr = curr / 3;
            }
        }
        System.out.println(minOp[n - 1]);
        for (int step:
             steps) {
            System.out.print(step + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new MinOperationsBU().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
