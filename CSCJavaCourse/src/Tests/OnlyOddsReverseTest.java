package Tests;

import java.util.ArrayDeque;
import java.util.Scanner;

import static Collections.CollectionsFunctions.*;

public class OnlyOddsReverseTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int k = -1;

        while (scan.hasNextInt()) {
            k++;
            if (k % 2 == 1) {
                numbers.add(scan.nextInt());
                continue;
            }
            scan.nextInt();
        }

        onlyOddsReverse(numbers);
    }
}
