package nl.jiankai.year2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day14 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static int minX = Integer.MAX_VALUE, maxX, minY = Integer.MAX_VALUE, maxY;
    static int sand = 0;

    private static void part1() {
        getMinMaxBoundaries();
        char[][] m = fillMap();
        try {
            for (int i = 0; i < 1000000; i++) {
                dropSand(m);
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(sand);
        }

    }

    static int lastX, lastY;

    private static void part2() {
        getMinMaxBoundaries2();
        char[][] m = fillMap();
        for (int i = 0; i < 1000000; i++) {
            dropSand(m);
            if (lastX == (500 - minX) && lastY == (0 - minY)) {
                System.out.println(sand);
                break;
            }
        }
    }

    private static void dropSand(char[][] m) {
        int x = 500 - minX, y = 0 - minY;
        while (canDropFurther(m, x, y)) {
            if (m[y + 1][x] != '.') {
                if (x > 0 && m[y + 1][x - 1] == '.') {
                    x--;
                } else if (x < (maxX - 1) && m[y + 1][x + 1] == '.') {
                    x++;
                } else {
                    y--;
                }
            }
            y++;
        }

        sand++;
        lastX = x;
        lastY = y;
        m[y][x] = 'o';
    }

    private static boolean canDropFurther(char[][] m, int x, int y) {
        return ((m[y + 1][x] == '.' || (m[y + 1][x] != '.' && (m[y + 1][x - 1] == '.') || (m[y + 1][x + 1] == '.'))));
    }

    private static char[][] fillMap() {
        char[][] m = new char[maxY - minY + 1][maxX - minX + 1];
        for (char[] line : m) {
            Arrays.fill(line, '.');
        }
        for (String line : input) {
            String[] coordinates = line.split(" -> ");
            for (int i = 1; i < coordinates.length; i++) {
                String[] split = coordinates[i - 1].split(",");
                String[] split2 = coordinates[i].split(",");
                int x = Integer.parseInt(split[0]);
                int x2 = Integer.parseInt(split2[0]);
                int y = Integer.parseInt(split[1]);
                int y2 = Integer.parseInt(split2[1]);
                if (x < x2) {
                    for (int j = x; j <= x2; j++) {
                        m[y - minY][j - minX] = '#';
                    }
                } else if (x > x2) {
                    for (int j = x2; j <= x; j++) {
                        m[y - minY][j - minX] = '#';
                    }
                } else if (y < y2) {
                    for (int j = y; j <= y2; j++) {
                        m[j - minY][x - minX] = '#';
                    }
                } else if (y > y2) {
                    for (int j = y2; j <= y; j++) {
                        m[j - minY][x - minX] = '#';
                    }
                }
            }
        }
        return m;
    }

    private static void print(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(" " + m[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void getMinMaxBoundaries() {
        input.add("500,0");
        for (String line : input) {
            String[] coordinates = line.split(" -> ");
            for (String coordinate : coordinates) {
                String[] split = coordinate.split(",");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

    }

    private static void getMinMaxBoundaries2() {
        getMinMaxBoundaries();
        minX -= 1000;
        maxX += 1000;
        maxY += 2;
        input.add("%s,%s -> %s,%s".formatted(minX, maxY, maxX, maxY));
    }

    private static List<String> input = new ArrayList<>(Arrays.asList(("498,13 -> 498,17 -> 491,17 -> 491,21 -> 507,21 -> 507,17 -> 502,17 -> 502,13\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "498,13 -> 498,17 -> 491,17 -> 491,21 -> 507,21 -> 507,17 -> 502,17 -> 502,13\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "468,113 -> 472,113\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "438,152 -> 442,152\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "474,117 -> 478,117\n" +
            "495,39 -> 511,39 -> 511,38\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "471,93 -> 483,93 -> 483,92\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "498,13 -> 498,17 -> 491,17 -> 491,21 -> 507,21 -> 507,17 -> 502,17 -> 502,13\n" +
            "441,150 -> 445,150\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "456,125 -> 456,128 -> 453,128 -> 453,134 -> 462,134 -> 462,128 -> 460,128 -> 460,125\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "471,93 -> 483,93 -> 483,92\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "456,125 -> 456,128 -> 453,128 -> 453,134 -> 462,134 -> 462,128 -> 460,128 -> 460,125\n" +
            "503,64 -> 503,67 -> 496,67 -> 496,71 -> 512,71 -> 512,67 -> 508,67 -> 508,64\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "456,125 -> 456,128 -> 453,128 -> 453,134 -> 462,134 -> 462,128 -> 460,128 -> 460,125\n" +
            "493,78 -> 497,78\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "483,48 -> 487,48\n" +
            "484,81 -> 484,84 -> 481,84 -> 481,88 -> 492,88 -> 492,84 -> 488,84 -> 488,81\n" +
            "498,13 -> 498,17 -> 491,17 -> 491,21 -> 507,21 -> 507,17 -> 502,17 -> 502,13\n" +
            "465,115 -> 469,115\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "462,117 -> 466,117\n" +
            "471,115 -> 475,115\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "456,125 -> 456,128 -> 453,128 -> 453,134 -> 462,134 -> 462,128 -> 460,128 -> 460,125\n" +
            "498,13 -> 498,17 -> 491,17 -> 491,21 -> 507,21 -> 507,17 -> 502,17 -> 502,13\n" +
            "499,78 -> 503,78\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "503,64 -> 503,67 -> 496,67 -> 496,71 -> 512,71 -> 512,67 -> 508,67 -> 508,64\n" +
            "450,156 -> 454,156\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "498,13 -> 498,17 -> 491,17 -> 491,21 -> 507,21 -> 507,17 -> 502,17 -> 502,13\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "495,48 -> 499,48\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "498,46 -> 502,46\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "487,78 -> 491,78\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "495,44 -> 499,44\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "486,46 -> 490,46\n" +
            "483,97 -> 492,97 -> 492,96\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "468,117 -> 472,117\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "484,81 -> 484,84 -> 481,84 -> 481,88 -> 492,88 -> 492,84 -> 488,84 -> 488,81\n" +
            "444,152 -> 448,152\n" +
            "489,48 -> 493,48\n" +
            "492,42 -> 496,42\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "484,81 -> 484,84 -> 481,84 -> 481,88 -> 492,88 -> 492,84 -> 488,84 -> 488,81\n" +
            "496,76 -> 500,76\n" +
            "503,64 -> 503,67 -> 496,67 -> 496,71 -> 512,71 -> 512,67 -> 508,67 -> 508,64\n" +
            "503,64 -> 503,67 -> 496,67 -> 496,71 -> 512,71 -> 512,67 -> 508,67 -> 508,64\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "456,125 -> 456,128 -> 453,128 -> 453,134 -> 462,134 -> 462,128 -> 460,128 -> 460,125\n" +
            "435,154 -> 439,154\n" +
            "503,64 -> 503,67 -> 496,67 -> 496,71 -> 512,71 -> 512,67 -> 508,67 -> 508,64\n" +
            "441,154 -> 445,154\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "447,154 -> 451,154\n" +
            "459,121 -> 459,122 -> 470,122 -> 470,121\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "495,39 -> 511,39 -> 511,38\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "493,74 -> 497,74\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "484,81 -> 484,84 -> 481,84 -> 481,88 -> 492,88 -> 492,84 -> 488,84 -> 488,81\n" +
            "492,46 -> 496,46\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "444,156 -> 448,156\n" +
            "459,121 -> 459,122 -> 470,122 -> 470,121\n" +
            "459,121 -> 459,122 -> 470,122 -> 470,121\n" +
            "438,156 -> 442,156\n" +
            "490,76 -> 494,76\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "432,156 -> 436,156\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "456,125 -> 456,128 -> 453,128 -> 453,134 -> 462,134 -> 462,128 -> 460,128 -> 460,125\n" +
            "489,44 -> 493,44\n" +
            "483,97 -> 492,97 -> 492,96\n" +
            "503,64 -> 503,67 -> 496,67 -> 496,71 -> 512,71 -> 512,67 -> 508,67 -> 508,64\n" +
            "484,81 -> 484,84 -> 481,84 -> 481,88 -> 492,88 -> 492,84 -> 488,84 -> 488,81\n" +
            "484,81 -> 484,84 -> 481,84 -> 481,88 -> 492,88 -> 492,84 -> 488,84 -> 488,81\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "484,81 -> 484,84 -> 481,84 -> 481,88 -> 492,88 -> 492,84 -> 488,84 -> 488,81\n" +
            "456,125 -> 456,128 -> 453,128 -> 453,134 -> 462,134 -> 462,128 -> 460,128 -> 460,125\n" +
            "506,61 -> 506,57 -> 506,61 -> 508,61 -> 508,56 -> 508,61 -> 510,61 -> 510,55 -> 510,61 -> 512,61 -> 512,56 -> 512,61 -> 514,61 -> 514,56 -> 514,61 -> 516,61 -> 516,60 -> 516,61 -> 518,61 -> 518,55 -> 518,61\n" +
            "503,64 -> 503,67 -> 496,67 -> 496,71 -> 512,71 -> 512,67 -> 508,67 -> 508,64\n" +
            "502,34 -> 502,33 -> 502,34 -> 504,34 -> 504,31 -> 504,34 -> 506,34 -> 506,27 -> 506,34 -> 508,34 -> 508,25 -> 508,34 -> 510,34 -> 510,32 -> 510,34 -> 512,34 -> 512,33 -> 512,34\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n" +
            "474,110 -> 474,103 -> 474,110 -> 476,110 -> 476,103 -> 476,110 -> 478,110 -> 478,108 -> 478,110 -> 480,110 -> 480,100 -> 480,110 -> 482,110 -> 482,103 -> 482,110 -> 484,110 -> 484,104 -> 484,110 -> 486,110 -> 486,103 -> 486,110 -> 488,110 -> 488,101 -> 488,110\n" +
            "498,13 -> 498,17 -> 491,17 -> 491,21 -> 507,21 -> 507,17 -> 502,17 -> 502,13\n" +
            "501,48 -> 505,48\n" +
            "444,147 -> 444,142 -> 444,147 -> 446,147 -> 446,142 -> 446,147 -> 448,147 -> 448,140 -> 448,147 -> 450,147 -> 450,137 -> 450,147 -> 452,147 -> 452,138 -> 452,147 -> 454,147 -> 454,142 -> 454,147 -> 456,147 -> 456,145 -> 456,147 -> 458,147 -> 458,140 -> 458,147\n").split("\n")));
}