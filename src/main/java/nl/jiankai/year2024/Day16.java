package nl.jiankai.year2024;


import java.util.*;

public class Day16 {
    public static void main(String[] args) {
        part1();
    }

    private static void part1() {
        List<String[]> grid = Arrays.stream(input.split("\n")).map(s->s.split("")).toList();

        int sx = 0;
        int sy = 0;
        int ex = 0;
        int ey = 0;

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length; j++) {
                if (grid.get(i)[j].equals("S")) {
                    sy = i;
                    sx = j;
                } else if (grid.get(i)[j].equals("E")) {
                    ex = j;
                    ey = i;
                }
            }
        }
        Queue<Cost> costs = new LinkedList<>();
        Map<Pos, Integer> dp = new HashMap<>();
        costs.add(new Cost(sx, sy, 0, Cost.Direction.EAST));

        while (!costs.isEmpty()) {
            Cost current = costs.poll();

        }
    }

    private record Cost(int x, int y, int cost, Direction direction) {
        private enum Direction {
            NORTH,
            EAST,
            SOUTH,
            WEST;


            public Direction move(int times) {
                return Direction.values()[(this.ordinal() + times)%4];
            }
        }
    }

    private record Pos(int x, int y) {}

    private static String input = """
###############
#.......#....E#
#.#.###.#.###.#
#.....#.#...#.#
#.###.#####.#.#
#.#.#.......#.#
#.#.#####.###.#
#...........#.#
###.#.#####.#.#
#...#.....#.#.#
#.#.#.###.#.#.#
#.....#...#.#.#
#.###.#.#.#.#.#
#S..#.....#...#
###############""";

}
