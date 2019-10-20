package Collections;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionsFunctions {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set1Temp = new LinkedHashSet<>(set1);
        Set<T> set2Temp = new LinkedHashSet<>(set2);
        set1Temp.retainAll(set2);
        set2Temp.addAll(set1);
        set2Temp.removeAll(set1Temp);
        return set2Temp;
    }
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x) ;
    }

    public static void onlyOddsReverse(Deque<Integer> c) {
        Iterator<Integer> iterator = c.descendingIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
