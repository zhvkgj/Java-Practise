package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EditDistBU {
    private void run() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("input.txt"));
        char[] str1 = scan.nextLine().toCharArray();
        char[] str2 = scan.nextLine().toCharArray();
        if (str1.length < str2.length) {
            char[] temp = str2;
            str2 = str1;
            str1 = temp;
        }
        int[] prev = new int[str2.length + 1];
        int[] cur = new int[str2.length + 1];
        for (int i = 0; i < str2.length + 1; i++) {
            prev[i] = i;
        }

        for (int i = 0; i < str1.length; i++) {
            cur[0] = i + 1;
            for (int j = 0; j < str2.length; j++) {
                int c = diff(str1[i], str2[j]);
                cur[j + 1] = Math.min(Math.min(prev[j + 1] + 1, cur[j] + 1), prev[j] + c);
            }
            System.arraycopy(cur, 0, prev, 0, prev.length);
        }
        System.out.println(cur[str2.length]);
    }

    private int diff(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }

    public static void main(String[] args) throws FileNotFoundException{
        long startTime = System.currentTimeMillis();
        new EditDistBU().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
