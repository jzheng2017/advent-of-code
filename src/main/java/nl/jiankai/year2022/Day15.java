package nl.jiankai.year2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day15 {
    private static List<Coordinate> coordinates = new ArrayList<>();
    private static List<ClosestBeacon> closestBeacons = new ArrayList<>();

    public static void main(String[] args) {
        part1();
    }

    private static int minX = Integer.MAX_VALUE, maxX, minY = Integer.MAX_VALUE, maxY;

    private static void part1() {
        parseCoordinates();
        getMinMaxBoundaries();
        char[][] m = new char[maxY - minY + 1][maxX - minX + 1];
        fillMap(m);
        fillProximity(m);
        countPositions(m, 2000000);
        System.out.println();
    }

    private static void countPositions(char[][] m, int y) {
        char[] line = m[y];
        int count = 0;
        for (char c : line) {
            if (c == '#') {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void fillProximity(char[][] m) {
        for (ClosestBeacon closestBeacon : closestBeacons) {
            Coordinate sensor = closestBeacon.sensor;
            Coordinate beacon = closestBeacon.beacon;
            int manhattanDistance = manhattanDistance(sensor.x, sensor.y, beacon.x, beacon.y);
            int left = Math.max(minX, sensor.x - manhattanDistance);
            int right = Math.min(maxX, sensor.x + manhattanDistance);
            int up = Math.max(minY, sensor.y - manhattanDistance);
            int down = Math.min(maxY, sensor.y + manhattanDistance);

            for (int i = left; i <= right; i++) {
                for (int j = up; j <= down; j++) {
                    if (manhattanDistance(sensor.x, sensor.y, i, j) <= manhattanDistance && m[j - minY][i - minX] == '.') {
                        m[j - minY][i - minX] = '#';
                    }
                }
            }
//            print(m);
        }
    }

    private static int manhattanDistance(int x, int y, int x2, int y2) {
        return Math.abs(x - x2) + Math.abs(y - y2);
    }

    private static void fillMap(char[][] m) {
        for (char[] l : m) {
            Arrays.fill(l, '.');
        }

        for (Coordinate coordinate : coordinates) {
            m[coordinate.y - minY][coordinate.x - minX] = coordinate.type.equals("sensor") ? 'S' : 'B';
        }
    }

    private static void getMinMaxBoundaries() {
        for (Coordinate coordinate : coordinates) {
            minX = Math.min(minX, coordinate.x);
            maxX = Math.max(maxX, coordinate.x);
            minY = Math.min(minY, coordinate.y);
            maxY = Math.max(maxY, coordinate.y);
        }
    }

    private record ClosestBeacon(Coordinate sensor, Coordinate beacon) {
    }

    private static void parseCoordinates() {
        for (String line : input) {
            String[] split = line.replace(",", "").replace(":", "").split(" ");
            Coordinate sensor = new Coordinate(
                    "sensor",
                    Integer.parseInt(split[2].replace("x=", "")),
                    Integer.parseInt(split[3].replace("y=", "")));
            coordinates.add(sensor);
            Coordinate beacon = new Coordinate(
                    "beacon",
                    Integer.parseInt(split[8].replace("x=", "")),
                    Integer.parseInt(split[9].replace("y=", "")));
            coordinates.add(beacon);
            closestBeacons.add(new ClosestBeacon(sensor, beacon));
        }
    }

    private record Coordinate(String type, int x, int y) {

    }

    private static void print(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(" " + m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<String> input = Arrays.asList(("Sensor at x=3391837, y=2528277: closest beacon is at x=3448416, y=2478759\n" +
            "Sensor at x=399473, y=1167503: closest beacon is at x=1188862, y=2000000\n" +
            "Sensor at x=3769110, y=2896086: closest beacon is at x=4076658, y=2478123\n" +
            "Sensor at x=900438, y=3835648: closest beacon is at x=-435606, y=3506717\n" +
            "Sensor at x=2913762, y=3937542: closest beacon is at x=2964244, y=3612685\n" +
            "Sensor at x=3646459, y=3446878: closest beacon is at x=3264675, y=3635510\n" +
            "Sensor at x=1182092, y=2135147: closest beacon is at x=1188862, y=2000000\n" +
            "Sensor at x=3213897, y=2710772: closest beacon is at x=3448416, y=2478759\n" +
            "Sensor at x=3242113, y=3984214: closest beacon is at x=3264675, y=3635510\n" +
            "Sensor at x=2809237, y=3782833: closest beacon is at x=2872059, y=3592616\n" +
            "Sensor at x=2962421, y=37354: closest beacon is at x=3358601, y=-1111474\n" +
            "Sensor at x=3456740, y=2458922: closest beacon is at x=3448416, y=2478759\n" +
            "Sensor at x=1799203, y=3569221: closest beacon is at x=2872059, y=3592616\n" +
            "Sensor at x=3907873, y=3898376: closest beacon is at x=3264675, y=3635510\n" +
            "Sensor at x=3481951, y=2453964: closest beacon is at x=3448416, y=2478759\n" +
            "Sensor at x=1120077, y=2963237: closest beacon is at x=1188862, y=2000000\n" +
            "Sensor at x=2901181, y=3029961: closest beacon is at x=2872059, y=3592616\n" +
            "Sensor at x=3111105, y=3361570: closest beacon is at x=2964244, y=3612685\n" +
            "Sensor at x=2533601, y=3956413: closest beacon is at x=2872059, y=3592616\n" +
            "Sensor at x=108898, y=2275290: closest beacon is at x=1188862, y=2000000\n" +
            "Sensor at x=3501591, y=2414995: closest beacon is at x=3448416, y=2478759\n" +
            "Sensor at x=3035657, y=3700769: closest beacon is at x=2964244, y=3612685\n" +
            "Sensor at x=1286795, y=298997: closest beacon is at x=308571, y=-434280\n" +
            "Sensor at x=200812, y=3470019: closest beacon is at x=-435606, y=3506717\n" +
            "Sensor at x=2550124, y=1556776: closest beacon is at x=1188862, y=2000000\n" +
            "Sensor at x=3955070, y=601908: closest beacon is at x=4076658, y=2478123\n" +
            "Sensor at x=3565419, y=2355172: closest beacon is at x=3448416, y=2478759\n").split("\n"));
}
