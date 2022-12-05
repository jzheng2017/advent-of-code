package nl.jiankai.year2022;

import java.util.*;
import java.util.stream.IntStream;

public class Day5 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        List<LinkedList<Character>> crates = createCollectionOfCrates();

        for (String move : moves) {
            String[] words = move.split(" ");
            int amount = Integer.parseInt(words[1]);
            int from = Integer.parseInt(words[3]);
            int to = Integer.parseInt(words[5]);
            LinkedList<Character> fromStack = crates.get(from-1);
            LinkedList<Character> toStack = crates.get(to-1);

            for (int i = 0; i < amount; i++) {
                toStack.add(fromStack.pollLast());
            }
        }

        for (LinkedList stack : crates) {
            System.out.print(stack.peekLast());
        }
        System.out.println();
    }

    private static void part2() {
        List<LinkedList<Character>> crates = createCollectionOfCrates();
        for (String move : moves) {
            String[] words = move.split(" ");
            int amount = Integer.parseInt(words[1]);
            int from = Integer.parseInt(words[3]);
            int to = Integer.parseInt(words[5]);
            LinkedList<Character> fromStack = crates.get(from - 1);
            LinkedList<Character> toStack = crates.get(to - 1);
            int start = fromStack.size() - amount;
            int end =  fromStack.size();

            List<Character> subList = new ArrayList<>(fromStack.subList(start, end));
            fromStack.subList(start, end).clear();
            toStack.addAll(subList);
        }

        for (LinkedList<Character> el : crates) {
            System.out.print(el.peekLast());
        }
    }

    private static List<LinkedList<Character>> createCollectionOfCrates() {
        List<LinkedList<Character>> stacks = new ArrayList<>();
        String stackNumbersLine = crates.get(crates.size() - 1);
        List<Integer> cratePositions = new ArrayList<>();

        for (int i = 0; i < stackNumbersLine.length(); i++) {
            if (Character.isDigit(stackNumbersLine.charAt(i))) {
                cratePositions.add(i);
            }
        }

        IntStream.range(0, cratePositions.size()).forEach((x) -> stacks.add(new LinkedList<>()));

        for (int i = crates.size() - 2; i >= 0; i--) {
            String line = crates.get(i);
            for (int j = 0; j < cratePositions.size(); j++) {
                LinkedList<Character> stack = stacks.get(j);
                char c = line.charAt(cratePositions.get(j));
                if (Character.isLetter(c)) {
                    stack.add(c);
                }
            }
        }

        return stacks;
    }
    private static List<String> crates2 = Arrays.asList(("    [D]    \n" +
            "[N] [C]    \n" +
            "[Z] [M] [P]\n" +
            " 1   2   3 ").split("\n"));

    private static List<String> moves2 = Arrays.asList(("move 1 from 2 to 1\n" +
            "move 3 from 1 to 3\n" +
            "move 2 from 2 to 1\n" +
            "move 1 from 1 to 2").split("\n"));
    private static List<String> crates = Arrays.asList(("[Q] [J]                         [H]\n" +
            "[G] [S] [Q]     [Z]             [P]\n" +
            "[P] [F] [M]     [F]     [F]     [S]\n" +
            "[R] [R] [P] [F] [V]     [D]     [L]\n" +
            "[L] [W] [W] [D] [W] [S] [V]     [G]\n" +
            "[C] [H] [H] [T] [D] [L] [M] [B] [B]\n" +
            "[T] [Q] [B] [S] [L] [C] [B] [J] [N]\n" +
            "[F] [N] [F] [V] [Q] [Z] [Z] [T] [Q]\n" +
            " 1   2   3   4   5   6   7   8   9 ").split("\n"));

    private static List<String> moves = Arrays.asList((
            "move 1 from 8 to 1\n" +
                    "move 1 from 6 to 1\n" +
                    "move 3 from 7 to 4\n" +
                    "move 3 from 2 to 9\n" +
                    "move 11 from 9 to 3\n" +
                    "move 1 from 6 to 9\n" +
                    "move 15 from 3 to 9\n" +
                    "move 5 from 2 to 3\n" +
                    "move 3 from 7 to 5\n" +
                    "move 6 from 9 to 3\n" +
                    "move 6 from 1 to 6\n" +
                    "move 2 from 3 to 7\n" +
                    "move 5 from 4 to 5\n" +
                    "move 7 from 9 to 4\n" +
                    "move 2 from 9 to 5\n" +
                    "move 10 from 4 to 2\n" +
                    "move 6 from 5 to 4\n" +
                    "move 2 from 7 to 6\n" +
                    "move 10 from 2 to 3\n" +
                    "move 21 from 3 to 5\n" +
                    "move 1 from 3 to 6\n" +
                    "move 3 from 6 to 9\n" +
                    "move 1 from 8 to 9\n" +
                    "move 5 from 4 to 5\n" +
                    "move 4 from 9 to 3\n" +
                    "move 17 from 5 to 1\n" +
                    "move 1 from 6 to 2\n" +
                    "move 16 from 5 to 1\n" +
                    "move 3 from 3 to 6\n" +
                    "move 6 from 6 to 4\n" +
                    "move 1 from 2 to 4\n" +
                    "move 4 from 1 to 2\n" +
                    "move 2 from 6 to 2\n" +
                    "move 28 from 1 to 3\n" +
                    "move 1 from 9 to 7\n" +
                    "move 1 from 8 to 7\n" +
                    "move 1 from 5 to 4\n" +
                    "move 1 from 2 to 6\n" +
                    "move 1 from 3 to 1\n" +
                    "move 3 from 2 to 5\n" +
                    "move 1 from 6 to 3\n" +
                    "move 4 from 4 to 7\n" +
                    "move 5 from 5 to 2\n" +
                    "move 1 from 5 to 6\n" +
                    "move 6 from 1 to 3\n" +
                    "move 1 from 6 to 2\n" +
                    "move 26 from 3 to 6\n" +
                    "move 2 from 7 to 9\n" +
                    "move 4 from 7 to 3\n" +
                    "move 19 from 6 to 3\n" +
                    "move 6 from 2 to 4\n" +
                    "move 5 from 3 to 2\n" +
                    "move 1 from 9 to 7\n" +
                    "move 26 from 3 to 8\n" +
                    "move 6 from 4 to 3\n" +
                    "move 1 from 3 to 8\n" +
                    "move 1 from 6 to 7\n" +
                    "move 6 from 3 to 6\n" +
                    "move 6 from 6 to 4\n" +
                    "move 1 from 9 to 2\n" +
                    "move 2 from 4 to 9\n" +
                    "move 22 from 8 to 2\n" +
                    "move 2 from 6 to 5\n" +
                    "move 1 from 9 to 1\n" +
                    "move 1 from 6 to 5\n" +
                    "move 1 from 7 to 5\n" +
                    "move 3 from 6 to 7\n" +
                    "move 2 from 6 to 1\n" +
                    "move 1 from 1 to 5\n" +
                    "move 3 from 5 to 9\n" +
                    "move 4 from 8 to 4\n" +
                    "move 2 from 1 to 4\n" +
                    "move 18 from 2 to 1\n" +
                    "move 2 from 7 to 8\n" +
                    "move 3 from 9 to 5\n" +
                    "move 8 from 1 to 9\n" +
                    "move 5 from 9 to 3\n" +
                    "move 1 from 9 to 8\n" +
                    "move 2 from 9 to 4\n" +
                    "move 2 from 7 to 8\n" +
                    "move 5 from 5 to 7\n" +
                    "move 1 from 9 to 3\n" +
                    "move 4 from 8 to 4\n" +
                    "move 1 from 7 to 8\n" +
                    "move 4 from 4 to 3\n" +
                    "move 2 from 8 to 3\n" +
                    "move 1 from 8 to 9\n" +
                    "move 2 from 1 to 8\n" +
                    "move 3 from 4 to 5\n" +
                    "move 1 from 8 to 4\n" +
                    "move 1 from 9 to 3\n" +
                    "move 1 from 8 to 5\n" +
                    "move 8 from 1 to 8\n" +
                    "move 11 from 2 to 9\n" +
                    "move 12 from 3 to 5\n" +
                    "move 1 from 3 to 9\n" +
                    "move 1 from 8 to 5\n" +
                    "move 11 from 9 to 3\n" +
                    "move 4 from 5 to 9\n" +
                    "move 3 from 8 to 7\n" +
                    "move 3 from 7 to 8\n" +
                    "move 1 from 5 to 8\n" +
                    "move 7 from 4 to 3\n" +
                    "move 1 from 4 to 5\n" +
                    "move 1 from 2 to 8\n" +
                    "move 3 from 7 to 6\n" +
                    "move 3 from 4 to 8\n" +
                    "move 1 from 7 to 9\n" +
                    "move 2 from 4 to 7\n" +
                    "move 5 from 8 to 1\n" +
                    "move 3 from 6 to 5\n" +
                    "move 2 from 4 to 2\n" +
                    "move 1 from 9 to 4\n" +
                    "move 1 from 8 to 6\n" +
                    "move 1 from 2 to 9\n" +
                    "move 1 from 8 to 5\n" +
                    "move 3 from 8 to 4\n" +
                    "move 3 from 4 to 2\n" +
                    "move 4 from 3 to 9\n" +
                    "move 17 from 5 to 9\n" +
                    "move 9 from 9 to 6\n" +
                    "move 1 from 9 to 3\n" +
                    "move 5 from 6 to 3\n" +
                    "move 3 from 6 to 3\n" +
                    "move 8 from 9 to 5\n" +
                    "move 2 from 8 to 5\n" +
                    "move 1 from 4 to 8\n" +
                    "move 1 from 5 to 3\n" +
                    "move 1 from 8 to 5\n" +
                    "move 3 from 2 to 6\n" +
                    "move 3 from 1 to 4\n" +
                    "move 7 from 5 to 1\n" +
                    "move 1 from 2 to 6\n" +
                    "move 13 from 3 to 6\n" +
                    "move 2 from 7 to 8\n" +
                    "move 13 from 6 to 5\n" +
                    "move 3 from 5 to 7\n" +
                    "move 6 from 5 to 6\n" +
                    "move 1 from 7 to 6\n" +
                    "move 2 from 7 to 3\n" +
                    "move 1 from 6 to 8\n" +
                    "move 13 from 3 to 5\n" +
                    "move 9 from 5 to 9\n" +
                    "move 7 from 5 to 7\n" +
                    "move 17 from 9 to 2\n" +
                    "move 3 from 4 to 7\n" +
                    "move 9 from 2 to 9\n" +
                    "move 10 from 9 to 3\n" +
                    "move 8 from 7 to 8\n" +
                    "move 2 from 5 to 3\n" +
                    "move 4 from 2 to 6\n" +
                    "move 11 from 3 to 9\n" +
                    "move 9 from 6 to 5\n" +
                    "move 5 from 9 to 8\n" +
                    "move 1 from 3 to 1\n" +
                    "move 3 from 9 to 1\n" +
                    "move 2 from 5 to 2\n" +
                    "move 1 from 7 to 9\n" +
                    "move 2 from 9 to 4\n" +
                    "move 2 from 9 to 8\n" +
                    "move 13 from 1 to 8\n" +
                    "move 3 from 8 to 5\n" +
                    "move 27 from 8 to 1\n" +
                    "move 10 from 5 to 9\n" +
                    "move 1 from 7 to 2\n" +
                    "move 2 from 4 to 3\n" +
                    "move 10 from 9 to 6\n" +
                    "move 1 from 8 to 7\n" +
                    "move 15 from 1 to 9\n" +
                    "move 13 from 9 to 5\n" +
                    "move 15 from 5 to 7\n" +
                    "move 5 from 1 to 3\n" +
                    "move 8 from 7 to 1\n" +
                    "move 7 from 7 to 1\n" +
                    "move 16 from 1 to 8\n" +
                    "move 4 from 3 to 9\n" +
                    "move 4 from 1 to 7\n" +
                    "move 4 from 9 to 6\n" +
                    "move 5 from 2 to 7\n" +
                    "move 15 from 8 to 6\n" +
                    "move 1 from 9 to 1\n" +
                    "move 3 from 3 to 4\n" +
                    "move 1 from 9 to 7\n" +
                    "move 1 from 2 to 7\n" +
                    "move 1 from 2 to 7\n" +
                    "move 1 from 8 to 1\n" +
                    "move 3 from 4 to 8\n" +
                    "move 3 from 8 to 1\n" +
                    "move 8 from 6 to 8\n" +
                    "move 7 from 1 to 4\n" +
                    "move 11 from 6 to 8\n" +
                    "move 14 from 6 to 5\n" +
                    "move 13 from 8 to 7\n" +
                    "move 4 from 7 to 5\n" +
                    "move 15 from 7 to 4\n" +
                    "move 6 from 5 to 4\n" +
                    "move 2 from 5 to 9\n" +
                    "move 1 from 5 to 2\n" +
                    "move 3 from 8 to 5\n" +
                    "move 19 from 4 to 7\n" +
                    "move 10 from 5 to 8\n" +
                    "move 2 from 6 to 8\n" +
                    "move 1 from 4 to 8\n" +
                    "move 2 from 7 to 9\n" +
                    "move 9 from 7 to 4\n" +
                    "move 6 from 4 to 6\n" +
                    "move 11 from 4 to 8\n" +
                    "move 2 from 5 to 4\n" +
                    "move 5 from 6 to 4\n" +
                    "move 1 from 6 to 7\n" +
                    "move 3 from 9 to 5\n" +
                    "move 3 from 8 to 5\n" +
                    "move 3 from 7 to 6\n" +
                    "move 11 from 8 to 7\n" +
                    "move 1 from 9 to 5\n" +
                    "move 1 from 6 to 8\n" +
                    "move 1 from 2 to 1\n" +
                    "move 5 from 4 to 9\n" +
                    "move 2 from 4 to 1\n" +
                    "move 2 from 1 to 4\n" +
                    "move 1 from 1 to 9\n" +
                    "move 4 from 5 to 1\n" +
                    "move 1 from 4 to 6\n" +
                    "move 17 from 7 to 5\n" +
                    "move 9 from 8 to 7\n" +
                    "move 6 from 9 to 7\n" +
                    "move 3 from 1 to 9\n" +
                    "move 12 from 7 to 9\n" +
                    "move 12 from 9 to 5\n" +
                    "move 5 from 7 to 9\n" +
                    "move 17 from 5 to 3\n" +
                    "move 7 from 3 to 1\n" +
                    "move 5 from 1 to 5\n" +
                    "move 5 from 9 to 2\n" +
                    "move 4 from 3 to 5\n" +
                    "move 1 from 4 to 8\n" +
                    "move 5 from 2 to 1\n" +
                    "move 22 from 5 to 9\n" +
                    "move 3 from 7 to 6\n" +
                    "move 6 from 6 to 9\n" +
                    "move 2 from 5 to 4\n" +
                    "move 1 from 6 to 3\n" +
                    "move 2 from 4 to 1\n" +
                    "move 3 from 8 to 2\n" +
                    "move 1 from 3 to 4\n" +
                    "move 24 from 9 to 1\n" +
                    "move 4 from 3 to 9\n" +
                    "move 2 from 2 to 9\n" +
                    "move 2 from 3 to 1\n" +
                    "move 1 from 8 to 6\n" +
                    "move 1 from 6 to 9\n" +
                    "move 1 from 8 to 9\n" +
                    "move 2 from 7 to 4\n" +
                    "move 1 from 8 to 3\n" +
                    "move 1 from 4 to 7\n" +
                    "move 3 from 9 to 8\n" +
                    "move 1 from 2 to 1\n" +
                    "move 9 from 9 to 3\n" +
                    "move 1 from 8 to 7\n" +
                    "move 1 from 4 to 3\n" +
                    "move 2 from 9 to 7\n" +
                    "move 1 from 9 to 3\n" +
                    "move 2 from 8 to 4\n" +
                    "move 12 from 3 to 8\n" +
                    "move 2 from 1 to 7\n" +
                    "move 1 from 4 to 3\n" +
                    "move 30 from 1 to 5\n" +
                    "move 6 from 5 to 7\n" +
                    "move 12 from 7 to 2\n" +
                    "move 1 from 3 to 4\n" +
                    "move 2 from 1 to 3\n" +
                    "move 1 from 4 to 9\n" +
                    "move 10 from 5 to 7\n" +
                    "move 10 from 2 to 6\n" +
                    "move 8 from 8 to 3\n" +
                    "move 3 from 1 to 3\n" +
                    "move 5 from 6 to 3\n" +
                    "move 2 from 8 to 5\n" +
                    "move 1 from 9 to 2\n" +
                    "move 2 from 8 to 6\n" +
                    "move 4 from 7 to 2\n" +
                    "move 3 from 2 to 7\n" +
                    "move 2 from 7 to 5\n" +
                    "move 1 from 4 to 9\n" +
                    "move 11 from 3 to 1\n" +
                    "move 7 from 6 to 9\n" +
                    "move 3 from 2 to 3\n" +
                    "move 10 from 1 to 7\n" +
                    "move 14 from 7 to 5\n" +
                    "move 3 from 7 to 6\n" +
                    "move 5 from 9 to 7\n" +
                    "move 29 from 5 to 7\n" +
                    "move 6 from 3 to 9\n" +
                    "move 2 from 9 to 7\n" +
                    "move 15 from 7 to 5\n" +
                    "move 11 from 5 to 6\n" +
                    "move 5 from 9 to 5\n" +
                    "move 10 from 5 to 8\n" +
                    "move 1 from 2 to 4\n" +
                    "move 1 from 8 to 2\n" +
                    "move 2 from 4 to 3\n" +
                    "move 2 from 5 to 9\n" +
                    "move 8 from 8 to 9\n" +
                    "move 11 from 9 to 3\n" +
                    "move 1 from 1 to 8\n" +
                    "move 18 from 7 to 3\n" +
                    "move 1 from 9 to 3\n" +
                    "move 28 from 3 to 5\n" +
                    "move 12 from 6 to 7\n" +
                    "move 1 from 2 to 9\n" +
                    "move 15 from 7 to 2\n" +
                    "move 1 from 8 to 1\n" +
                    "move 10 from 2 to 9\n" +
                    "move 10 from 5 to 3\n" +
                    "move 2 from 2 to 3\n" +
                    "move 18 from 3 to 4\n" +
                    "move 6 from 9 to 4\n" +
                    "move 1 from 1 to 7\n" +
                    "move 1 from 6 to 4\n" +
                    "move 1 from 8 to 2\n" +
                    "move 1 from 9 to 4\n" +
                    "move 2 from 9 to 4\n" +
                    "move 19 from 4 to 3\n" +
                    "move 1 from 7 to 9\n" +
                    "move 1 from 9 to 7\n" +
                    "move 1 from 6 to 8\n" +
                    "move 3 from 2 to 8\n" +
                    "move 2 from 9 to 5\n" +
                    "move 15 from 3 to 1\n" +
                    "move 7 from 5 to 1\n" +
                    "move 3 from 4 to 9\n" +
                    "move 1 from 7 to 2\n" +
                    "move 3 from 3 to 1\n" +
                    "move 6 from 5 to 2\n" +
                    "move 3 from 3 to 9\n" +
                    "move 4 from 9 to 2\n" +
                    "move 5 from 5 to 3\n" +
                    "move 1 from 3 to 5\n" +
                    "move 3 from 5 to 7\n" +
                    "move 3 from 8 to 5\n" +
                    "move 1 from 7 to 5\n" +
                    "move 4 from 5 to 1\n" +
                    "move 4 from 4 to 2\n" +
                    "move 2 from 7 to 8\n" +
                    "move 12 from 1 to 6\n" +
                    "move 1 from 8 to 6\n" +
                    "move 6 from 2 to 3\n" +
                    "move 9 from 3 to 8\n" +
                    "move 1 from 3 to 4\n" +
                    "move 3 from 6 to 1\n" +
                    "move 2 from 9 to 2\n" +
                    "move 1 from 4 to 5\n" +
                    "move 2 from 8 to 3\n" +
                    "move 10 from 2 to 1\n" +
                    "move 2 from 4 to 7\n" +
                    "move 12 from 1 to 4\n" +
                    "move 1 from 5 to 1\n" +
                    "move 7 from 4 to 9\n" +
                    "move 2 from 3 to 2\n" +
                    "move 6 from 9 to 2\n" +
                    "move 1 from 9 to 1\n" +
                    "move 1 from 7 to 8\n" +
                    "move 5 from 6 to 7\n" +
                    "move 3 from 6 to 1\n" +
                    "move 6 from 2 to 3\n" +
                    "move 2 from 4 to 3\n" +
                    "move 1 from 6 to 8\n" +
                    "move 1 from 6 to 7\n" +
                    "move 8 from 3 to 9\n" +
                    "move 2 from 4 to 5\n" +
                    "move 3 from 2 to 4\n" +
                    "move 10 from 8 to 2\n" +
                    "move 22 from 1 to 9\n" +
                    "move 9 from 2 to 4\n" +
                    "move 1 from 1 to 3\n" +
                    "move 1 from 3 to 2\n" +
                    "move 3 from 2 to 4\n" +
                    "move 2 from 7 to 1\n" +
                    "move 14 from 4 to 2\n" +
                    "move 2 from 1 to 8\n" +
                    "move 2 from 4 to 5\n" +
                    "move 4 from 7 to 8\n" +
                    "move 24 from 9 to 6\n" +
                    "move 3 from 5 to 9\n" +
                    "move 1 from 9 to 8\n" +
                    "move 1 from 5 to 2\n" +
                    "move 1 from 6 to 7\n" +
                    "move 6 from 9 to 1\n" +
                    "move 1 from 7 to 3\n" +
                    "move 5 from 8 to 6\n" +
                    "move 9 from 6 to 3\n" +
                    "move 4 from 1 to 4\n" +
                    "move 2 from 1 to 2\n" +
                    "move 11 from 6 to 3\n" +
                    "move 13 from 3 to 2\n" +
                    "move 2 from 9 to 8\n" +
                    "move 8 from 3 to 8\n" +
                    "move 2 from 8 to 5\n" +
                    "move 1 from 7 to 5\n" +
                    "move 3 from 6 to 3\n" +
                    "move 11 from 8 to 5\n" +
                    "move 13 from 2 to 4\n" +
                    "move 10 from 5 to 2\n" +
                    "move 2 from 3 to 4\n" +
                    "move 2 from 5 to 7\n" +
                    "move 15 from 4 to 9\n" +
                    "move 2 from 7 to 4\n" +
                    "move 2 from 4 to 2\n" +
                    "move 2 from 4 to 9\n" +
                    "move 2 from 4 to 2\n" +
                    "move 1 from 3 to 8\n" +
                    "move 1 from 8 to 1\n" +
                    "move 1 from 1 to 2\n" +
                    "move 1 from 6 to 3\n" +
                    "move 7 from 2 to 4\n" +
                    "move 1 from 5 to 3\n" +
                    "move 7 from 9 to 1\n" +
                    "move 7 from 1 to 2\n" +
                    "move 4 from 6 to 9\n" +
                    "move 12 from 9 to 7\n" +
                    "move 6 from 7 to 5\n" +
                    "move 1 from 3 to 5\n" +
                    "move 7 from 4 to 7\n" +
                    "move 3 from 7 to 8\n" +
                    "move 3 from 8 to 6\n" +
                    "move 18 from 2 to 9\n" +
                    "move 7 from 2 to 3\n" +
                    "move 15 from 9 to 4\n" +
                    "move 3 from 3 to 9\n" +
                    "move 1 from 3 to 1\n" +
                    "move 3 from 5 to 4\n" +
                    "move 1 from 1 to 2\n" +
                    "move 1 from 9 to 2\n" +
                    "move 2 from 6 to 2\n" +
                    "move 5 from 7 to 6\n" +
                    "move 5 from 2 to 7\n" +
                    "move 3 from 3 to 4\n" +
                    "move 5 from 5 to 3\n" +
                    "move 6 from 7 to 4\n" +
                    "move 9 from 4 to 2\n" +
                    "move 18 from 4 to 9\n" +
                    "move 6 from 2 to 1\n" +
                    "move 1 from 1 to 9\n" +
                    "move 4 from 7 to 4\n" +
                    "move 7 from 2 to 4\n" +
                    "move 1 from 2 to 8\n" +
                    "move 1 from 4 to 2\n" +
                    "move 4 from 3 to 4\n" +
                    "move 16 from 9 to 5\n" +
                    "move 9 from 9 to 8\n" +
                    "move 1 from 9 to 7\n" +
                    "move 4 from 1 to 2\n" +
                    "move 2 from 5 to 4\n" +
                    "move 10 from 5 to 4\n" +
                    "move 4 from 2 to 1\n" +
                    "move 5 from 1 to 2\n" +
                    "move 1 from 8 to 5\n" +
                    "move 1 from 6 to 5\n" +
                    "move 4 from 8 to 5\n" +
                    "move 2 from 6 to 9\n" +
                    "move 3 from 6 to 2\n" +
                    "move 2 from 9 to 1\n" +
                    "move 1 from 7 to 6\n" +
                    "move 1 from 3 to 8\n" +
                    "move 9 from 5 to 9\n" +
                    "move 4 from 8 to 1\n" +
                    "move 2 from 8 to 2\n" +
                    "move 1 from 5 to 7\n" +
                    "move 9 from 9 to 8\n" +
                    "move 1 from 7 to 5\n" +
                    "move 9 from 8 to 2\n" +
                    "move 6 from 1 to 6\n" +
                    "move 6 from 2 to 6\n" +
                    "move 10 from 2 to 5\n" +
                    "move 5 from 2 to 1\n" +
                    "move 1 from 3 to 5\n" +
                    "move 8 from 5 to 4\n" +
                    "move 5 from 1 to 3\n" +
                    "move 10 from 6 to 8\n" +
                    "move 3 from 6 to 9\n" +
                    "move 4 from 3 to 1\n" +
                    "move 5 from 8 to 2\n" +
                    "move 4 from 5 to 9\n" +
                    "move 1 from 3 to 7\n" +
                    "move 1 from 7 to 3\n" +
                    "move 1 from 8 to 6\n" +
                    "move 1 from 6 to 1\n" +
                    "move 15 from 4 to 8\n" +
                    "move 5 from 9 to 2\n" +
                    "move 1 from 9 to 1\n" +
                    "move 1 from 1 to 3\n" +
                    "move 6 from 4 to 8\n" +
                    "move 12 from 8 to 7\n" +
                    "move 1 from 3 to 5\n" +
                    "move 3 from 1 to 9\n" +
                    "move 13 from 4 to 9\n" +
                    "move 5 from 7 to 2\n" +
                    "move 1 from 5 to 4\n" +
                    "move 8 from 9 to 5\n" +
                    "move 6 from 2 to 5\n" +
                    "move 2 from 5 to 6\n").split("\n"));
}
