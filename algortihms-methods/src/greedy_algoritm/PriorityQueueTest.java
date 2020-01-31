package greedy_algoritm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        MyPriorityQueue queue = new MyPriorityQueue(new ArrayList<>());
        List<Integer> result = new LinkedList<>();
        while (n > 0) {
            String command = scan.nextLine();
            String[] strings = command.split(" ");
            switch (strings[0]) {
                case "Insert":
                    queue.Insert(Integer.parseInt(strings[1]));
                    for (Integer num:queue.data
                         ) {
                        System.out.print(num + " ");
                    }
                    break;
                case "ExtractMax":
                    result.add(queue.ExtractMax());
                    for (Integer num:queue.data
                    ) {
                        System.out.print(num + " ");
                    }
                    break;
                default:
                    break;
            }
            n--;
        }
        for (Integer num : result) {
            System.out.println(num);
        }
    }
}
