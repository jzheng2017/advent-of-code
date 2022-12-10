package nl.jiankai.year2022;

import java.util.Arrays;
import java.util.List;

public class Day10 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        int cycles = 0;
        int sum = 1;
        int ans = 0;
        for (String cmd : input) {
            String[] split = cmd.split(" ");
            if (split[0].equals("noop")) {
                cycles++;
                if (cycles == 20 || cycles == 60 || cycles == 100 || cycles == 140 || cycles == 180 || cycles == 220) {
                    ans += cycles * sum;
                }
            } else {
                cycles++;
                if (cycles == 20 || cycles == 60 || cycles == 100 || cycles == 140 || cycles == 180 || cycles == 220) {
                    ans += cycles * sum;
                }
                cycles++;
                if (cycles == 20 || cycles == 60 || cycles == 100 || cycles == 140 || cycles == 180 || cycles == 220) {
                    ans += cycles * sum;
                }
                sum += Integer.parseInt(split[1]);
            }

        }
        System.out.println(ans);
    }

    private static void part2() {
        int cycles = 0;
        int X = 1;
        int row = 0;
        boolean[][] m = new boolean[6][40];

        for (String cmd : input) {
            String[] split = cmd.split(" ");
            if (split[0].equals("noop")) {
                m[row][cycles % 40] = Math.abs(cycles%40 - X) < 2;
                cycles++;
                if (cycles % 40 == 0) {
                    row++;
                }

            } else {
                m[row][cycles % 40] = Math.abs(cycles%40 - X) < 2;
                cycles++;
                if (cycles % 40 == 0) {
                    row++;
                }
                m[row][cycles % 40] = Math.abs(cycles%40 - X) < 2;
                cycles++;
                if (cycles % 40 == 0) {
                    row++;
                }
                X += Integer.parseInt(split[1]);
            }

        }
        drawWord(m);
    }

    private static void drawWord(boolean[][] m) {
        for(int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] ? "#" : ".");
            }
            System.out.println();
        }
    }

    private static List<String> input = Arrays.asList(("noop\n" +
            "noop\n" +
            "addx 5\n" +
            "addx 29\n" +
            "addx -28\n" +
            "addx 5\n" +
            "addx -1\n" +
            "noop\n" +
            "noop\n" +
            "addx 5\n" +
            "addx 12\n" +
            "addx -6\n" +
            "noop\n" +
            "addx 4\n" +
            "addx -1\n" +
            "addx 1\n" +
            "addx 5\n" +
            "addx -31\n" +
            "addx 32\n" +
            "addx 4\n" +
            "addx 1\n" +
            "noop\n" +
            "addx -38\n" +
            "addx 5\n" +
            "addx 2\n" +
            "addx 3\n" +
            "addx -2\n" +
            "addx 2\n" +
            "noop\n" +
            "addx 3\n" +
            "addx 2\n" +
            "addx 5\n" +
            "addx 2\n" +
            "addx 3\n" +
            "noop\n" +
            "addx 2\n" +
            "addx 3\n" +
            "noop\n" +
            "addx 2\n" +
            "addx -32\n" +
            "addx 33\n" +
            "addx -20\n" +
            "addx 27\n" +
            "addx -39\n" +
            "addx 1\n" +
            "noop\n" +
            "addx 5\n" +
            "addx 3\n" +
            "noop\n" +
            "addx 2\n" +
            "addx 5\n" +
            "noop\n" +
            "noop\n" +
            "addx -2\n" +
            "addx 5\n" +
            "addx 2\n" +
            "addx -16\n" +
            "addx 21\n" +
            "addx -1\n" +
            "addx 1\n" +
            "noop\n" +
            "addx 3\n" +
            "addx 5\n" +
            "addx -22\n" +
            "addx 26\n" +
            "addx -39\n" +
            "noop\n" +
            "addx 5\n" +
            "addx -2\n" +
            "addx 2\n" +
            "addx 5\n" +
            "addx 2\n" +
            "addx 23\n" +
            "noop\n" +
            "addx -18\n" +
            "addx 1\n" +
            "noop\n" +
            "noop\n" +
            "addx 2\n" +
            "noop\n" +
            "noop\n" +
            "addx 7\n" +
            "addx 3\n" +
            "noop\n" +
            "addx 2\n" +
            "addx -27\n" +
            "addx 28\n" +
            "addx 5\n" +
            "addx -11\n" +
            "addx -27\n" +
            "noop\n" +
            "noop\n" +
            "addx 3\n" +
            "addx 2\n" +
            "addx 5\n" +
            "addx 2\n" +
            "addx 27\n" +
            "addx -26\n" +
            "addx 2\n" +
            "addx 5\n" +
            "addx 2\n" +
            "addx 4\n" +
            "addx -3\n" +
            "addx 2\n" +
            "addx 5\n" +
            "addx 2\n" +
            "addx 3\n" +
            "addx -2\n" +
            "addx 2\n" +
            "noop\n" +
            "addx -33\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "addx 31\n" +
            "addx -26\n" +
            "addx 6\n" +
            "noop\n" +
            "noop\n" +
            "addx -1\n" +
            "noop\n" +
            "addx 3\n" +
            "addx 5\n" +
            "addx 3\n" +
            "noop\n" +
            "addx -1\n" +
            "addx 5\n" +
            "addx 1\n" +
            "addx -12\n" +
            "addx 17\n" +
            "addx -1\n" +
            "addx 5\n" +
            "noop\n" +
            "noop\n" +
            "addx 1\n" +
            "noop\n" +
            "noop\n").split("\n"));
}
