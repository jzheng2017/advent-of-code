package nl.jiankai.year2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {
    public static void main(String[] args) {
        part1_2();
    }

    static void part1_2() {
        long[] fishes = new long[9];

        for (int num : input) {
            fishes[num]++;
        }

        for (int i = 0; i < 256; i++) {
            long tmp = fishes[0];
            for (int j = 1; j < fishes.length; j++) {
                fishes[j - 1] = fishes[j];
            }
            fishes[6] += tmp;
            fishes[8] = tmp;
        }

        long totalFishes = 0;

        for (long fish : fishes) {
            totalFishes += fish;
        }

        System.out.println(totalFishes);
    }

    static List<Integer> input = Arrays.stream(("1,4,3,3,1,3,1,1,1,2,1,1,1,4,4,1,5,5,3,1,3,5,2,1,5,2,4,1,4,5,4,1,5,1,5,5,1,1,1,4,1,5,1,1,1,1,1,4,1,2,5,1,4,1,2,1,1,5,1,1,1,1,4,1,5,1,1,2,1,4,5,1,2,1,2,2,1,1,1,1,1,5,5,3,1,1,1,1,1,4,2,4,1,2,1,4,2,3,1,4,5,3,3,2,1,1,5,4,1,1,1,2,1,1,5,4,5,1,3,1,1,1,1,1,1,2,1,3,1,2,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,4,5,1,3,1,4,4,2,3,4,1,1,1,5,1,1,1,4,1,5,4,3,1,5,1,1,1,1,1,5,4,1,1,1,4,3,1,3,3,1,3,2,1,1,3,1,1,4,5,1,1,1,1,1,3,1,4,1,3,1,5,4,5,1,1,5,1,1,4,1,1,1,3,1,1,4,2,3,1,1,1,1,2,4,1,1,1,1,1,2,3,1,5,5,1,4,1,1,1,1,3,3,1,4,1,2,1,3,1,1,1,3,2,2,1,5,1,1,3,2,1,1,5,1,1,1,1,1,1,1,1,1,1,2,5,1,1,1,1,3,1,1,1,1,1,1,1,1,5,5,1").split(",")).map(Integer::parseInt).collect(Collectors.toList());
}
