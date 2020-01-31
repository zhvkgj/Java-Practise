package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinCoinsBU {
    private void run() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] coins = new int[k];
        for (int i = 0; i < k; i++) {
            coins[i] = scan.nextInt();
        }
        int[] minCount = new int[n + 1];
        minCount[0] = 0;
        minCount[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            minCount[i] = Integer.MAX_VALUE;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int coin : coins) {
                if (coin <= i)
                    minCount[i] = Math.min(minCount[i], minCount[i - coin] + 1);
            }
        }
        System.out.println(minCount[n]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new MinCoinsBU().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
