package nl.jiankai.year2021;

import java.util.Arrays;
import java.util.List;

public class Day11 {
    static int numberOfFlashes = 0;

    public static void main(String[] args) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                grid[i][j] = Character.getNumericValue(input.get(i).charAt(j));
            }
        }
        //        part1();
        part2();
    }

    static void part1() {
        int step = 100;

        for (int i = 0; i < step; i++) {
            performStep();
        }

        System.out.println(numberOfFlashes);
    }

    static void performStep() {
        flashes = new boolean[grid.length][grid[0].length];
        for (int j = 0; j < grid.length; j++) {
            for (int z = 0; z < grid[j].length; z++) {
                grid[j][z]++;
            }
        }

        for (int j = 0; j < grid.length; j++) {
            for (int z = 0; z < grid[j].length; z++) {
                if (grid[j][z] == 10) {
                    flash(j, z);
                }
            }
        }
    }

    static void part2() {
        int step = 0;
        while (!allFlash()) {
            performStep();
            step++;
        }
        System.out.println(step);
    }

    static void flash(int x, int y) {
        if (flashes[x][y]) {
            return;
        }

        grid[x][y]++;

        if (grid[x][y] < 10) {
            return;
        }

        grid[x][y] = 0;
        numberOfFlashes++;
        flashes[x][y] = true;
        if (x > 0) {
            flash(x - 1, y);
        }

        if (x > 0 && y > 0) {
            flash(x - 1, y - 1);
        }

        if (x > 0 && y < grid[x].length - 1) {
            flash(x - 1, y + 1);
        }

        if (x < grid.length - 1) {
            flash(x + 1, y);
        }

        if (x < grid.length - 1 && y > 0) {
            flash(x + 1, y - 1);
        }

        if (x < grid.length - 1 && y < grid[x].length - 1) {
            flash(x + 1, y + 1);
        }

        if (y > 0) {
            flash(x, y - 1);
        }

        if (y < grid[x].length - 1) {
            flash(x, y + 1);
        }
    }

    static boolean allFlash() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static List<String> input = Arrays.asList(("8448854321\n" +
            "4447645251\n" +
            "6542573645\n" +
            "4725275268\n" +
            "6442514153\n" +
            "4515734868\n" +
            "5513676158\n" +
            "3257376185\n" +
            "2172424467\n" +
            "6775163586").split("\n"));
    static int[][] grid = new int[input.size()][input.get(0).length()];
    static boolean[][] flashes = new boolean[input.size()][input.get(0).length()];

}
