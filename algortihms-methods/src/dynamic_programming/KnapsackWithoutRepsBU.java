package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapsackWithoutRepsBU {
    private void run() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        int w = scan.nextInt();
        int n = scan.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scan.nextInt();
        }
        int[][] maxValues = new int[w + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            maxValues[0][i] = 0;
        }
        for (int i = 1; i < w + 1; i++) {
            maxValues[i][0] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                maxValues[j][i] = maxValues[j][i - 1];
                int curWeight = weights[i - 1];
                if (curWeight <= j) {
                    maxValues[j][i] = Math.max(maxValues[j][i], maxValues[j - curWeight][i - 1] + curWeight);
                }
            }
        }
        System.out.println(maxValues[w][n]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new KnapsackWithoutRepsBU().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}