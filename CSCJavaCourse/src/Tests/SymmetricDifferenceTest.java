package Tests;

import static Collections.CollectionsFunctions.*;

import java.util.*;

public class SymmetricDifferenceTest {
    public static void main(String[] args) {

        Set<Integer> num1 = new HashSet<>();
        num1.add(1);
        num1.add(2);
        num1.add(3);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(0);
        num2.add(1);
        num2.add(2);

        Set<Integer> result = symmetricDifference(num1, num2);
        System.out.println(result);

    }
}
