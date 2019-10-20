package Collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsFunctions {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> mid(x));
    }

    private static int mid(int number) {
        return ((number * number) / 10) % 1000;
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        // first -- min element, second -- max element
        Object[] arr = new Object[2];
        stream.forEach((t) -> {
            arr[0] = arr[0] == null ? t : order.compare(t, (T) arr[0]) < 0 ? t : arr[0];
            arr[1] = arr[1] == null ? t : order.compare(t, (T) arr[1]) > 0 ? t : arr[1];
        });
        minMaxConsumer.accept((T) arr[0], (T) arr[1]);
    }

    public static void mostFrequentWords() {
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))
                .lines()
                .map(String::toLowerCase)
                .map(lines -> lines.split("[^a-zA-Zа-яА-Я0-9']+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}
