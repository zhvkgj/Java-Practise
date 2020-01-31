package greedy_algoritm;

import java.util.*;

public class Greedy {
    public static List<Integer> coverSegments(List<Map.Entry<Integer, Integer>> segments) {
        if (segments.isEmpty()) throw new IllegalArgumentException("Argument cannot be an empty list!");
        segments.sort(Comparator.comparingInt(Map.Entry::getValue));
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < segments.size(); ++i) {
            Integer curPoint = segments.get(i).getValue();
            result.add(curPoint);
            while (++i < segments.size() &&
                    curPoint >= segments.get(i).getKey() &&
                    curPoint <= segments.get(i).getValue()) {
            }
            i--;
        }
        return result;
    }

    public static double knapsack(int capacity, List<Map.Entry<Integer, Integer>> goods) {
        if (goods.isEmpty()) throw new IllegalArgumentException("Argument cannot be an empty list!");
        goods.sort(Comparator.comparingDouble(good -> good.getKey().doubleValue() / good.getValue()));
        double result = 0;
        for (int i = goods.size() - 1; i > -1; --i) {
            if (goods.get(i).getValue() <= capacity) {
                capacity -= goods.get(i).getValue();
                result += goods.get(i).getKey();
            } else {
                result += goods.get(i).getKey().doubleValue() * capacity / goods.get(i).getValue();
                return result;
            }
        }
        return result;
    }

    public static List<Integer> numberExpansion(int n) {
        List<Integer> result = new LinkedList<>();
        if (n < 3) {
            result.add(n);
        } else {
            int sum = 0;
            int cur = 1;
            while (sum < n) {
                sum += cur;
                result.add(cur);
                cur++;
            }
            if (sum != n) {
                result.add(result.remove(result.size() - 1) + result.get(result.size() - 1) - (sum - n));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int capacity = scan.nextInt();
        List<Map.Entry<Integer, Integer>> points = new ArrayList<>();

        while (n != 0) {
            int value = scan.nextInt();
            int weight = scan.nextInt();
            points.add(new AbstractMap.SimpleEntry<>(value, weight));
            --n;
        }

        double result = knapsack(capacity, points);
        System.out.println(result);
    }
}
