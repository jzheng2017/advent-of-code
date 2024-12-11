package nl.jiankai.year2024;

import java.util.*;

public class Day11 {
    public static void main(String[] args) {
        part2();
    }

    public static void part1() {
        List<Long> list = Arrays.stream(input.split(" ")).map(Long::parseLong).toList();
        List<Long> temp = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            for (Long num : list) {
                if (num == 0) {
                    temp.add(1L);
                } else if (String.valueOf(Math.abs(num)).length() % 2 == 0) {
                    String str = String.valueOf(num);
                    Long left = Long.parseLong(str.substring(0, str.length() / 2));
                    Long right = Long.parseLong(str.substring(str.length() / 2));
                    temp.add(left);
                    temp.add(right);
                } else {
                    temp.add(num * 2024);
                }
            }
            list = temp;
            temp = new ArrayList<>();
        }

        System.out.println(list.size());
    }

    public static void part2() {
        List<Long> list = Arrays.stream(input.split(" ")).map(Long::parseLong).toList();
        Map<Long, Long> map = new HashMap<>();

        for (long l :   list) {
            map.put(l, map.getOrDefault(l, 0L) + 1);
        }

        Map<Long, Long> temp = new HashMap<>();
        for (int i = 0; i < 75; i++) {
            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                long num = entry.getKey();
                long value = entry.getValue();

                if (num == 0) {
                    temp.put(1L, temp.getOrDefault(1L, 0L) + value);
                } else if (String.valueOf(num).length() % 2 == 0) {
                    String str = String.valueOf(num);
                    Long left = Long.parseLong(str.substring(0, str.length() / 2));
                    Long right = Long.parseLong(str.substring(str.length() / 2));
                    temp.put(left, temp.getOrDefault(left, 0L) + value);
                    temp.put(right, temp.getOrDefault(right, 0L) + value);
                } else {
                    long val = num * 2024;
                    temp.put(val, temp.getOrDefault(val, 0L) + value);
                }
            }
            map = temp;
            temp = new HashMap<>();
        }

        System.out.println(map.values().stream().reduce(0L, Long::sum));
    }

    private static final String input = "5 89749 6061 43 867 1965860 0 206250";
}
