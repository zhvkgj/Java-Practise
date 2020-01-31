package greedy_algoritm;

import java.util.*;

public class Huffman {
    private static class ResultInfo {
        final Map<Character, StringBuilder> chars;
        final String resultString;

        ResultInfo(Map<Character, StringBuilder> chars, String resultString) {
            this.chars = chars;
            this.resultString = resultString;
        }
    }

    public static ResultInfo encode(char[] str) {
        Queue<Map.Entry<String, Integer>> queue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        Map<String, Integer> chars = new HashMap<>();
        for (char c : str) {
            Integer temp = chars.put(String.valueOf(c), 1);
            if (temp != null) {
                chars.put(String.valueOf(c), temp + 1);
            }
        }
        queue.addAll(chars.entrySet());
        Map<Character, StringBuilder> codes = new HashMap<>();

        while (queue.size() != 1) {
            Map.Entry<String, Integer> l = queue.remove();
            Map.Entry<String, Integer> r = queue.remove();

            queue.add(new AbstractMap.SimpleImmutableEntry<>(
                    l.getKey() + r.getKey(),
                    l.getValue() + r.getValue()
            ));

            if (l.getKey().length() == 1) {
                codes.put(l.getKey().charAt(0), new StringBuilder("0"));
            } else {
                char[] chars1 = l.getKey().toCharArray();
                for (char c : chars1) {
                    codes.get(c).append("0");
                }
            }

            if (r.getKey().length() == 1) {
                codes.put(r.getKey().charAt(0), new StringBuilder("1"));
            } else {
                char[] chars1 = r.getKey().toCharArray();
                for (char c : chars1) {
                    codes.get(c).append("1");
                }
            }
        }

        Map.Entry<String, Integer> single = queue.remove();
        if (single.getKey().length() == 1) {
            codes.put(single.getKey().charAt(0), new StringBuilder("0"));
        }
        codes.forEach((key, value) -> value.reverse());
        StringBuilder result = new StringBuilder();
        for (char c : str) {
            result.append(codes.get(c).toString());
        }

        return new ResultInfo(codes, result.toString());
    }

    public static String decode(ResultInfo arg) {
        Map<Character, StringBuilder> codes = arg.chars;
        String str = arg.resultString;
        StringBuilder result = new StringBuilder();
        while (str.length() != 0) {
            for (Map.Entry p : codes.entrySet()) {
                String regex = p.getValue().toString();
                if (str.startsWith(regex)) {
                    result.append(str.replaceFirst(regex, p.getKey().toString()).charAt(0));
                    str = str.substring(regex.length());
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str1 = scan.nextLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int length = Integer.parseInt(str1[1]);
        Map<Character, StringBuilder> code = new HashMap<>();
        while (n > 0) {
            String[] str2 = scan.nextLine().split(":");
            code.put(str2[0].charAt(0), new StringBuilder(str2[1].trim()));
            --n;
        }
        String str = scan.nextLine();
        ResultInfo entry = new ResultInfo(code, str);
        System.out.println(decode(entry));
    }
}
