package nl.jiankai.year2022;

import java.util.*;

public class Day12 {

    public static void main(String[] args) {
//        part1();
        part2();
    }

    private static int[][] minMap;
    private static char[][] dirMap;
    private static int eX, eY;
    private static int sX, sY;
    private static char[][] m;

    private static void part1() {
        setup();
        System.out.println(getFewestStep(m, sX, sY, 0));
    }

    private static void part2() {
        setup();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 'a') {
                    minMap = new int[m.length][m[0].length];
                    for (int[] ints : minMap) {
                        Arrays.fill(ints, Integer.MAX_VALUE);
                    }
                    min = Math.min(min, getFewestStep(m, j, i, 0));
                }
            }
        }

        System.out.println(min);
    }

    private static void setup() {
        m = new char[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                m[i][j] = input.get(i).charAt(j);
                if (m[i][j] == 'E') {
                    m[i][j] = 'z';
                    eX = j;
                    eY = i;
                }
                if (m[i][j] == 'S') {
                    m[i][j] = 'a';
                    sX = j;
                    sY = i;
                }
            }
        }
    }


    private static int getFewestStep(char[][] map, int x, int y, int steps) {
        if (steps >= minMap[y][x]) {
            return Integer.MAX_VALUE;
        }

        if (x == eX && y == eY) {
            minMap[y][x] = steps;
            return steps;
        }

        minMap[y][x] = steps;


        int nextStep = steps + 1;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE, up = Integer.MAX_VALUE, down = Integer.MAX_VALUE;

        if (x > 0 && (map[y][x - 1] - map[y][x]) <= 1) {
            left = getFewestStep(map, x - 1, y, nextStep);
        }
        if (x < map[0].length - 1 && (map[y][x + 1] - map[y][x]) <= 1) {
            right = getFewestStep(map, x + 1, y, nextStep);
        }
        if (y > 0 && (map[y - 1][x] - map[y][x]) <= 1) {
            up = getFewestStep(map, x, y - 1, nextStep);
        }
        if (y < map.length - 1 && (map[y + 1][x] - map[y][x]) <= 1) {
            down = getFewestStep(map, x, y + 1, nextStep);
        }
        int min = Math.min(Math.min(left, right), Math.min(up, down));
        return min;
    }

    private static List<String> input = Arrays.asList(("abaccccccccccccccaaaccccaaaaaaaaaaaaaccccccaacccccccccccccccccccccccccccccaaaaaa\n" +
            "abaaccaacccccccccaaaaaccccaaaaaaaaaaaaaccccaaacccccccccccccccccccccccccccccaaaaa\n" +
            "abaaccaaacccccccaaaaaacccaaaaaaaaaaaaaacaaaaaaaaccccccccaacccccccccccccccccccaaa\n" +
            "abcaaaaaaaacccccaaaaaacccaaaaaaaaaaaaaacaaaaaaaacccccccaaaacccccccccccccccccaaaa\n" +
            "abcaaaaaaaaccccccaaaaaccaaaaaaaaccaaaaaccaaaaaaccccccccaaaaccaaaccccccccccccaaac\n" +
            "abccaaaaaacccccccaaaaccaaaaaaaaaacaaaacccaaaaaacccccccccakkaaaaaacccccccccccaacc\n" +
            "abccaaaaaacccccccccccccaaaaaaaaaaccccccccaaaaaaccccccckkkkkkkaaacccccccccccccccc\n" +
            "abccaaaaaaccccccccccccccccaaaaaaaaaccccccaacaaacccccckkkkkkkkkaccccccaccaaaccccc\n" +
            "abccaacaaacccccaaccccccccaaacacaaaacaaccccccccccccccakkkoppkkkkicccccaaaaaaccccc\n" +
            "abccccccccccccaaaccccccccaacccccaaaaaaccccccccccccccjkkooppppkiicccccccaaaaccccc\n" +
            "abccccccccccaaaaaaaaccccccccccaaaaaaaccccccccccccccjjjooopppppiiiicccccccaaacccc\n" +
            "abaaacccccccaaaaaaaacccccccaacaaaaaaccccccccccccccjjjjooouuppppiiiiiicccccaacccc\n" +
            "abaaaccccccccaaaaaaccccccccaaaccaaaaacccccccccccjjjjjooouuuupppiiiiiiiiccccacccc\n" +
            "abaaaaaacccccaaaaaacccccaaaaaaaaaacaaaccccccccjjjjjjooouuuuuupppppiiiiiicccccccc\n" +
            "abaaaaaacccccaaaaaacccccaaaaaaaaaacccccccccccjjjjjooooouuxxuupppppqqqijjjccccccc\n" +
            "abaaaacccccaaaaccaaccccccaaaaaaccccccccccccciijjnooooouuuxxxuuupqqqqqqjjjdddcccc\n" +
            "abaaaaaccaaaaaaccacccccccaaaaaaccccccccccaaiiiinnootttuuxxxxuuvvvvvqqqjjjdddcccc\n" +
            "abaaaaaccaaaaaacaaaccaaccaaaaaaccccccccccaaiiinnnntttttuxxxxxvvvvvvqqqjjjdddcccc\n" +
            "abaaccacccaaaaacaaaaaaaccaaccaaccccccccccaaiiinnnttttxxxxxxxyyyyyvvqqqjjjdddcccc\n" +
            "abcccccccaaaaacccaaaaaaccccccaaaaacccccccaaiiinnntttxxxxxxxyyyyyvvvqqqjjjddccccc\n" +
            "SbcccccccaaaaacaaaaaaaaccccccaaaaaccccccccciiinnntttxxxEzzzzyyyyvvqqqjjjdddccccc\n" +
            "abcccccccccccccaaaaaaaaaccccaaaaaaccccccccciiinnnntttxxxxyyyyyvvvvqqjjjdddcccccc\n" +
            "abcccccccccccccaaaaaaaaaacccaaaaaacccccccccciiinnnttttxxxyyyyyvvvqqqjjjdddcccccc\n" +
            "abccccccccccccccccaaaaaaacccaaaaaaccccccccccciiinnnntttwyyywyyyvvrrrkkjdddcccccc\n" +
            "abcccccccccccccccaaaaaaaaccccaaaccccccccccccciiihnnnttwwwywwyyywvrrrkkkeeccccccc\n" +
            "abcccccccccccccccaaaaaaaaccccccccccccccccccccchhhmmmsswwwwwwwwwwwvrrkkkeeccccccc\n" +
            "abcccccccaacccccccacaaacccccccccccccccccccaacchhhhmmsswwwwwswwwwwrrrkkkeeccccccc\n" +
            "abcccccccaaaccacccccaaacccccccccccccccaaccaaccchhhmmssswwwssrrwwwrrrkkkeeccccccc\n" +
            "abcccccccaaaaaaacccccccccccaaaccccccccaaaaaaccchhhmmssssssssrrrrrrrrkkkeeaaacccc\n" +
            "abcccccaaaaaaaaccccccccccccaaaaccccccccaaaaaaachhhmmmssssssllrrrrrrkkkeeeaaacccc\n" +
            "abccccaaaaaaaaaccccccccccccaaaacccccccccaaaaacchhhmmmmsssllllllllkkkkkeeeaaacccc\n" +
            "abccccaaaaaaaaaccccccccccccaaacccccccccaaaaacccchhhmmmmmlllllllllkkkkeeeeaaccccc\n" +
            "abcccccccaaaaaaccccccccccaacccccccaaccaaacaacccchhhmmmmmlllgfflllkkffeeeaaaacccc\n" +
            "abccccccaaaaaaaccccccccccaaaaaaaaaaaaaccccaacccchhhggmmmggggffffffffffeaaaaacccc\n" +
            "abccaacccaacccaaaaccaccccaaaaaaaaaaaaacccccccccccgggggggggggffffffffffaacccccccc\n" +
            "abaaaaccaaaccccaaaaaaccccaaaaaacaaaaaaccccccccccccgggggggggaaaaccffccccccccccccc\n" +
            "abaaaacccccccccaaaaaaccaaaaaaaaaaaaaacccccccccccccccgggaaaaaaaacccccccccccccccca\n" +
            "abaaaaacccccccaaaaaaaccaaaaaaaaaaaaaacccccccccccccccccaaacccaaaaccccccccccccccaa\n" +
            "abaaaaacaaaaccaaaaaaaacaaaaaaaaaaaccccccccccccccccccccaaaccccaaaccccccccccaaacaa\n" +
            "abaaaaacaaaaccaaaaaaaaaaaaaaaaaaacccccccccccccccccccccccccccccccccccccccccaaaaaa\n" +
            "abaaacccaaaaccccaaaccccaaaaaaaaaaacccccccccccccccccccccccccccccccccccccccccaaaaa\n").split("\n"));
}
