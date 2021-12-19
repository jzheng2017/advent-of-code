package nl.jiankai.year2021;

import java.util.HashSet;
import java.util.Set;

public class Day17 {
    public static void main(String[] args) {
//        part1();
        part2();
    }

    private static void part1() {
        int answer = 0;
        for (int i = -250; i < 250; i++) {
            for (int j = -250; j < 250; j++) {
                int x = 0;
                int y = 0;
                int dx = i;
                int dy = j;
                int maxY = 0;
                for (int z = 0; z < 250; z++) {
                    x += dx;
                    y += dy;

                    maxY = Math.max(y, maxY);
                    if (dx > 0) {
                        dx -= 1;
                    } else if (dx < 0) {
                        dx += 1;
                    }
                    dy -= 1;

                    if (x >= 195 && x <= 238 && y >= -93 && y <= -67) {
                        answer = Math.max(answer, maxY);
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static void part2() {
        Set<String> distinctVelos = new HashSet<>();
        for (int i = -250; i < 250; i++) {
            for (int j = -250; j < 250; j++) {
                int x = 0;
                int y = 0;
                int dx = i;
                int dy = j;
                for (int z = 0; z < 500; z++) {
                    x += dx;
                    y += dy;

                    if (dx > 0) {
                        dx -= 1;
                    } else if (dx < 0) {
                        dx += 1;
                    }
                    dy -= 1;

                    if (x >= 195 && x <= 238 && y >= -93 && y <= -67) {
                        distinctVelos.add(i + "," + j);
                        break;
                    }
                }
            }
        }

        System.out.println(distinctVelos.size());
    }
}
