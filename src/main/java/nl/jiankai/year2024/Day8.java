package nl.jiankai.year2024;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Day8 {
    public static void main(String[] args) {
        part2();
    }

    private static void part1() {
        Map<String, List<Pos>> antennasMap = new HashMap<>();
        Set<Pos> allAntiNodes = new HashSet<>();
        List<String> lines = Arrays.stream(input.split("\n")).toList();
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                if (lines.get(i).charAt(j) != '.') {
                    antennasMap.merge(String.valueOf(lines.get(i).charAt(j)), new ArrayList<>(), (l, f) -> l).add(new Pos(j, i));
                }
            }
        }

        int width = lines.get(0).length();
        int height = lines.size();

        for (Map.Entry<String, List<Pos>> entry : antennasMap.entrySet()) {
            Set<Pos> antiNodes = new HashSet<>();
            List<Pos> antennas = entry.getValue();

            for (int i = 0; i < antennas.size(); i++) {
                Pos antenna = antennas.get(i);
                for (int j = i + 1; j < antennas.size(); j++) {
                    Pos antenna2 = antennas.get(j);
                    int xDiff = Math.abs(antennas.get(i).x - antennas.get(j).x);
                    int yDiff = Math.abs(antennas.get(i).y - antennas.get(j).y);

                    addAntiNodes(antenna, antenna2, xDiff, yDiff, width, height, antiNodes, antennas, lines);
                    addAntiNodes(antenna2, antenna, xDiff, yDiff, width, height, antiNodes, antennas, lines);
                }
            }
            allAntiNodes.addAll(antiNodes);
            System.out.println(antiNodes);

        }
        print(lines, allAntiNodes);
        System.out.println(allAntiNodes.size());
    }

    private static void print(List<String> lines, Set<Pos> antiNodes) {
        List<String[]> grid = lines.stream().map(s -> s.split("")).toList();
        antiNodes.forEach(anti -> {
            if (grid.get(anti.y)[anti.x].equals(".")) {
                grid.get(anti.y)[anti.x] = "#";
            }
        });
        for (String[] row : grid) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private static void addAntiNodes(Pos antenna, Pos antenna2, int xDiff, int yDiff, int width, int height, Set<Pos> antiNodes, List<Pos> antennas, List<String> lines) {
        Pos antiNode = new Pos(antenna.x - xDiff, antenna.y - yDiff);
        if (isElligible(xDiff, yDiff, width, height, antenna, antiNode, lines) && isElligible(xDiff, yDiff, width, height, antenna2, antiNode, lines)) {
            antiNodes.add(antiNode);
        }
        Pos antiNode2 = new Pos(antenna.x - xDiff, antenna.y + yDiff);
        if (isElligible(xDiff, yDiff, width, height, antenna, antiNode2, lines) && isElligible(xDiff, yDiff, width, height, antenna2, antiNode2, lines)) {
            antiNodes.add(antiNode2);
        }
        Pos antiNode3 = new Pos(antenna.x + xDiff, antenna.y - yDiff);
        if (isElligible(xDiff, yDiff, width, height, antenna, antiNode3, lines) && isElligible(xDiff, yDiff, width, height, antenna2, antiNode3, lines)) {
            antiNodes.add(antiNode3);
        }
        Pos antiNode4 = new Pos(antenna.x + xDiff, antenna.y + yDiff);
        if (isElligible(xDiff, yDiff, width, height, antenna, antiNode4, lines) && isElligible(xDiff, yDiff, width, height, antenna2, antiNode4, lines)) {
            antiNodes.add(antiNode4);
        }
    }

    private static boolean isElligible(int xDiff, int yDiff, int width, int height, Pos antenna, Pos antiNode, List<String> lines) {
        if (antiNode.x < 0 || antiNode.x >= width || antiNode.y < 0 || antiNode.y >= height) {
            return false;
        }
        return Math.abs(antenna.x - antiNode.x) >= xDiff && Math.abs(antenna.y - antiNode.y) >= yDiff;
    }

    private static void part2() {
        Map<String, List<Pos>> antennasMap = new HashMap<>();
        Set<Pos> allAntiNodes = new HashSet<>();
        List<String> lines = Arrays.stream(input.split("\n")).toList();
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                if (lines.get(i).charAt(j) != '.') {
                    antennasMap.merge(String.valueOf(lines.get(i).charAt(j)), new ArrayList<>(), (l, f) -> l).add(new Pos(j, i));
                }
            }
        }

        int width = lines.get(0).length();
        int height = lines.size();
        for (Map.Entry<String, List<Pos>> entry : antennasMap.entrySet()) {
            Set<Pos> antiNodes = new HashSet<>();
            List<Pos> antennas = entry.getValue();

            for (int i = 0; i < antennas.size(); i++) {
                Pos antenna = antennas.get(i);
                for (int j = i + 1; j < antennas.size(); j++) {
                    Pos antenna2 = antennas.get(j);
                    int xDiff = Math.abs(antennas.get(i).x - antennas.get(j).x);
                    int yDiff = Math.abs(antennas.get(i).y - antennas.get(j).y);
                    int mul = 0;
                    while (xDiff + (xDiff * mul) < width && yDiff + (yDiff * mul) < height) {
                        addAntiNodes2(antenna, antenna2, xDiff, yDiff, mul, width, height, antiNodes, antennas, lines);
                        addAntiNodes2(antenna2, antenna, xDiff, yDiff, mul, width, height, antiNodes, antennas, lines);
                        mul++;
                    }
                }
            }
            allAntiNodes.addAll(antiNodes);
            System.out.println(antiNodes);

        }
        print(lines, allAntiNodes);
        System.out.println(allAntiNodes.size());
    }

    private static void addAntiNodes2(Pos antenna, Pos antenna2, int xDiff, int yDiff, int mul, int width, int height, Set<Pos> antiNodes, List<Pos> antennas, List<String> lines) {
        int scaledxDiff = xDiff + (xDiff * mul);
        int scaledyDiff = yDiff + (yDiff * mul);
        Pos antiNode = new Pos(antenna.x - scaledxDiff, antenna.y - scaledyDiff);
        antiNodes.add(antenna2);
        if (antenna.x - xDiff != antenna2.x && antenna.y - yDiff != antenna2.y) {
            if (isElligible(xDiff, yDiff, width, height, antenna, antiNode, lines) && isElligible(xDiff, yDiff, width, height, antenna2, antiNode, lines)) {
                antiNodes.add(antiNode);
            }
        }
        Pos antiNode2 = new Pos(antenna.x - scaledxDiff, antenna.y + scaledyDiff);
        if (antenna.x - xDiff != antenna2.x && antenna.y + yDiff != antenna2.y) {
            if (isElligible(xDiff, yDiff, width, height, antenna, antiNode2, lines) && isElligible(xDiff, yDiff, width, height, antenna2, antiNode2, lines)) {
                antiNodes.add(antiNode2);
            }
        }
        if (antenna.x + xDiff != antenna2.x && antenna.y - yDiff != antenna2.y) {

            Pos antiNode3 = new Pos(antenna.x + scaledxDiff, antenna.y - scaledyDiff);
            if (isElligible(xDiff, yDiff, width, height, antenna, antiNode3, lines) && isElligible(xDiff, yDiff, width, height, antenna2, antiNode3, lines)) {
                antiNodes.add(antiNode3);
            }
        }
        if (antenna.x + xDiff != antenna2.x && antenna.y + yDiff != antenna2.y) {

            Pos antiNode4 = new Pos(antenna.x + scaledxDiff, antenna.y + scaledyDiff);
            if (isElligible(xDiff, yDiff, width, height, antenna, antiNode4, lines) && isElligible(xDiff, yDiff, width, height, antenna2, antiNode4, lines)) {
                antiNodes.add(antiNode4);
            }
        }
    }

    private record Pos(int x, int y) {

    }

    private static String input = """
.....8............1r.....a....................O...
.a..............4..q.........................0...9
....a.........8...................................
.................D.....................V0.........
.....d............................................
.r..........q....................................O
..................q...........................9...
..............D..............X..................V.
........D................X.................0......
.........8............X...........................
....................J....................9..0.....
..a..B............r..W........J...............R..Q
......WD...q.....1..........Q..............R..V...
.1W...................u...........................
..............................u.............R.....
....B..............d..c..................R........
.............J..............X............V........
......1...........................3...............
......B...........d...................3...........
............8..J.......u.....3....................
...........4.............6........................
.....4v.............d.......................O.....
..........................v.2.....................
.............................................s....
..................4...M..W..................s.....
......................m...........................
...........M......................................
..b..................c............................
....................Co..........KQ.......O.s......
.................C............................s...
.......x............c............................3
........o......A....U.....Q.........5.............
...............U..................j...5...........
.....K.......U................j..........2........
.......A.v.....w.....................c...5........
..K....................................j..........
...............K.yk....B.............2............
......C....b..............x...........Y...........
.....mA..C......U.................................
........M.....A.....................2..6...5......
.............................7.......Y............
.m.M......w..v....................................
............m...........x.....Y...................
....................k....w........................
......b.....w..S....7.............................
..............S..............x...........Y........
....................S...6.........................
.y...............S..........7.6.................9.
o..........k...............b......................
yo...........k....................................
""";
}
