package dynamic_programming;

import javax.swing.plaf.metal.MetalIconFactory;
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

        
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new StairsSumBU().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
