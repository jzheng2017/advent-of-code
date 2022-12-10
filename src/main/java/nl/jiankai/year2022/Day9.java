package nl.jiankai.year2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9 {
    public static void main(String[] args) {
        part1();
    }

    private static void part1() {
        Set<String> visited = new HashSet<>();
        int[][] positions = new int[10][2];


        for (String move : input) {
            String[] split = move.split(" ");
            int n = Integer.parseInt(split[1]);
            for (int i = 0; i < n; i++) {
                if (split[0].equals("R")) {
                    positions[9][0]++;
                } else if (split[0].equals("L")) {
                    positions[9][0]--;
                } else if (split[0].equals("U")) {
                    positions[9][1]--;
                } else if (split[0].equals("D")) {
                    positions[9][1]++;
                }

                for (int j = 8; j >= 0; j--) {
                    int tX = positions[j][0], tY = positions[j][1];
                    int hX = positions[j+1][0], hY = positions[j+1][1];
                    int dx = Math.abs(tX - hX);
                    int dy = Math.abs(tY - hY);

                    if (dx > 1 && dy == 0) {
                        if (split[0].equals("R")) {
                            tX++;
                        } else {
                            tX--;
                        }
                    } else if (dy > 1 && dx == 0) {
                        if (split[0].equals("U")) {
                            tY--;
                        } else {
                            tY++;
                        }
                    } else if ((dx > 1 || dy > 1 ) && Math.abs(dx-dy) == 1) {
                        if (split[0].equals("R")) {
                            tX = hX - 1;
                            tY = hY;
                        } else if (split[0].equals("L")) {
                            tX = hX + 1;
                            tY = hY;
                        } else if (split[0].equals("U")) {
                            tX = hX;
                            tY = hY + 1;
                        } else if (split[0].equals("D")) {
                            tX = hX;
                            tY = hY - 1;
                        }
                    }
                    positions[j][0] = tX;
                    positions[j][1] = tY;
                    if (j == 0) {
                        boolean newPosition = !visited.contains("(%s, %s)".formatted(tX, tY));
                        visited.add("(%s, %s)".formatted(tX, tY));
                        System.out.println("Direction: %s - %s Position %s: (%s, %s) Position %s: (%s, %s) Visited: %s New position: %s".formatted(split[0], n-i, j+1, hX, hY,j, tX, tY, visited, newPosition));
                    }
                }
            }
        }

        System.out.println(visited.size());
    }


    private static List<String> input = Arrays.asList(("R 5\n" +
            "U 8\n" +
            "L 8\n" +
            "D 3\n" +
            "R 17\n" +
            "D 10\n" +
            "L 25\n" +
            "U 20").split("\n"));
}
