package Tests;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static Collections.StreamsFunctions.*;

public class StreamTests {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntStream stream = Arrays.stream(numbers);
        stream.map(x -> 1).forEach(System.out::println);
        System.out.println("----------------");
        for (int n:
                numbers) {
            System.out.println(n);
        }
        pseudoRandomStream(13).limit(10).forEach(System.out::println);
        findMinMax(Stream.empty(), Integer::compare,
                (BiConsumer<Integer, Integer>) (t, t2) -> {
            if (t instanceof Integer){
                System.out.println(t + " " + t2);
            } else {
                System.out.println("null null");
            }
        });
        mostFrequentWords();
    }
}
