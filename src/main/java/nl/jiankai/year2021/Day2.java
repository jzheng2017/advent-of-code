package nl.jiankai.year2021;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {
    static List<String> input = Arrays.stream(("forward 2\n" +
            "down 8\n" +
            "down 1\n" +
            "up 7\n" +
            "forward 4\n" +
            "down 4\n" +
            "down 3\n" +
            "forward 2\n" +
            "forward 5\n" +
            "forward 2\n" +
            "forward 7\n" +
            "forward 8\n" +
            "down 7\n" +
            "forward 6\n" +
            "forward 1\n" +
            "down 8\n" +
            "down 8\n" +
            "up 9\n" +
            "down 9\n" +
            "forward 1\n" +
            "up 1\n" +
            "forward 6\n" +
            "forward 7\n" +
            "down 7\n" +
            "forward 4\n" +
            "forward 2\n" +
            "forward 1\n" +
            "forward 3\n" +
            "forward 8\n" +
            "forward 4\n" +
            "up 6\n" +
            "down 2\n" +
            "forward 4\n" +
            "down 3\n" +
            "up 3\n" +
            "up 2\n" +
            "up 3\n" +
            "forward 8\n" +
            "down 5\n" +
            "down 8\n" +
            "down 5\n" +
            "down 4\n" +
            "down 2\n" +
            "up 1\n" +
            "forward 6\n" +
            "forward 6\n" +
            "forward 8\n" +
            "up 5\n" +
            "down 5\n" +
            "forward 8\n" +
            "forward 7\n" +
            "down 9\n" +
            "down 7\n" +
            "down 6\n" +
            "down 3\n" +
            "forward 3\n" +
            "up 7\n" +
            "forward 2\n" +
            "up 6\n" +
            "forward 7\n" +
            "forward 9\n" +
            "down 9\n" +
            "forward 3\n" +
            "down 2\n" +
            "down 2\n" +
            "down 7\n" +
            "down 7\n" +
            "forward 8\n" +
            "down 7\n" +
            "forward 9\n" +
            "up 7\n" +
            "down 4\n" +
            "down 8\n" +
            "forward 2\n" +
            "forward 2\n" +
            "up 1\n" +
            "forward 8\n" +
            "down 5\n" +
            "forward 8\n" +
            "forward 4\n" +
            "up 1\n" +
            "forward 2\n" +
            "forward 2\n" +
            "forward 2\n" +
            "down 9\n" +
            "down 7\n" +
            "down 9\n" +
            "forward 9\n" +
            "forward 4\n" +
            "up 7\n" +
            "down 4\n" +
            "forward 9\n" +
            "forward 8\n" +
            "up 5\n" +
            "up 1\n" +
            "down 1\n" +
            "down 9\n" +
            "down 6\n" +
            "up 8\n" +
            "forward 2\n" +
            "forward 7\n" +
            "up 7\n" +
            "forward 7\n" +
            "forward 6\n" +
            "down 6\n" +
            "forward 8\n" +
            "up 6\n" +
            "forward 7\n" +
            "down 7\n" +
            "forward 4\n" +
            "forward 9\n" +
            "up 9\n" +
            "up 8\n" +
            "forward 8\n" +
            "forward 3\n" +
            "up 1\n" +
            "up 4\n" +
            "down 4\n" +
            "up 9\n" +
            "up 8\n" +
            "forward 6\n" +
            "down 2\n" +
            "down 2\n" +
            "up 4\n" +
            "forward 4\n" +
            "forward 1\n" +
            "down 8\n" +
            "forward 6\n" +
            "down 5\n" +
            "forward 6\n" +
            "down 8\n" +
            "up 1\n" +
            "forward 1\n" +
            "up 9\n" +
            "down 8\n" +
            "up 3\n" +
            "up 9\n" +
            "forward 9\n" +
            "forward 2\n" +
            "down 2\n" +
            "up 6\n" +
            "up 6\n" +
            "forward 8\n" +
            "up 3\n" +
            "down 3\n" +
            "forward 5\n" +
            "up 2\n" +
            "forward 1\n" +
            "forward 1\n" +
            "forward 8\n" +
            "down 4\n" +
            "forward 8\n" +
            "forward 7\n" +
            "down 8\n" +
            "forward 7\n" +
            "down 7\n" +
            "down 2\n" +
            "down 1\n" +
            "down 7\n" +
            "up 9\n" +
            "down 5\n" +
            "up 1\n" +
            "forward 7\n" +
            "down 5\n" +
            "down 9\n" +
            "down 2\n" +
            "down 8\n" +
            "down 4\n" +
            "forward 2\n" +
            "forward 2\n" +
            "forward 1\n" +
            "down 6\n" +
            "up 7\n" +
            "forward 2\n" +
            "down 1\n" +
            "down 5\n" +
            "forward 3\n" +
            "forward 8\n" +
            "down 4\n" +
            "up 2\n" +
            "up 9\n" +
            "up 7\n" +
            "forward 7\n" +
            "forward 4\n" +
            "up 8\n" +
            "up 3\n" +
            "up 4\n" +
            "forward 6\n" +
            "down 7\n" +
            "forward 7\n" +
            "up 6\n" +
            "down 9\n" +
            "up 6\n" +
            "forward 4\n" +
            "up 3\n" +
            "down 3\n" +
            "up 6\n" +
            "down 9\n" +
            "down 6\n" +
            "forward 7\n" +
            "forward 9\n" +
            "forward 2\n" +
            "down 6\n" +
            "up 3\n" +
            "up 9\n" +
            "forward 9\n" +
            "forward 8\n" +
            "up 4\n" +
            "up 5\n" +
            "forward 6\n" +
            "down 5\n" +
            "up 4\n" +
            "up 9\n" +
            "down 8\n" +
            "forward 5\n" +
            "up 5\n" +
            "forward 7\n" +
            "forward 6\n" +
            "down 8\n" +
            "down 5\n" +
            "down 2\n" +
            "up 5\n" +
            "down 8\n" +
            "forward 7\n" +
            "forward 7\n" +
            "up 6\n" +
            "forward 3\n" +
            "down 8\n" +
            "forward 5\n" +
            "forward 8\n" +
            "down 7\n" +
            "forward 6\n" +
            "down 2\n" +
            "forward 2\n" +
            "forward 8\n" +
            "down 4\n" +
            "forward 5\n" +
            "forward 7\n" +
            "forward 5\n" +
            "forward 8\n" +
            "forward 9\n" +
            "forward 6\n" +
            "down 6\n" +
            "up 7\n" +
            "down 9\n" +
            "forward 7\n" +
            "forward 1\n" +
            "up 2\n" +
            "forward 8\n" +
            "down 1\n" +
            "up 9\n" +
            "forward 7\n" +
            "down 2\n" +
            "up 2\n" +
            "forward 5\n" +
            "down 4\n" +
            "down 3\n" +
            "up 8\n" +
            "up 6\n" +
            "forward 3\n" +
            "up 4\n" +
            "forward 3\n" +
            "forward 1\n" +
            "forward 1\n" +
            "up 9\n" +
            "down 2\n" +
            "down 9\n" +
            "up 4\n" +
            "forward 4\n" +
            "forward 4\n" +
            "forward 2\n" +
            "forward 5\n" +
            "forward 9\n" +
            "forward 7\n" +
            "up 4\n" +
            "up 5\n" +
            "down 5\n" +
            "forward 9\n" +
            "down 1\n" +
            "forward 2\n" +
            "down 6\n" +
            "forward 9\n" +
            "down 4\n" +
            "down 2\n" +
            "forward 2\n" +
            "up 7\n" +
            "forward 7\n" +
            "forward 8\n" +
            "up 9\n" +
            "forward 3\n" +
            "up 1\n" +
            "down 5\n" +
            "forward 5\n" +
            "down 1\n" +
            "up 5\n" +
            "forward 4\n" +
            "forward 5\n" +
            "up 3\n" +
            "down 4\n" +
            "up 6\n" +
            "up 1\n" +
            "down 2\n" +
            "forward 6\n" +
            "down 8\n" +
            "up 9\n" +
            "down 7\n" +
            "forward 9\n" +
            "down 8\n" +
            "forward 3\n" +
            "forward 8\n" +
            "down 1\n" +
            "down 7\n" +
            "forward 6\n" +
            "up 6\n" +
            "down 1\n" +
            "down 5\n" +
            "forward 6\n" +
            "down 7\n" +
            "down 2\n" +
            "forward 6\n" +
            "forward 2\n" +
            "forward 8\n" +
            "forward 7\n" +
            "forward 2\n" +
            "down 7\n" +
            "up 2\n" +
            "down 7\n" +
            "forward 8\n" +
            "forward 8\n" +
            "forward 2\n" +
            "forward 4\n" +
            "down 1\n" +
            "down 6\n" +
            "down 1\n" +
            "down 4\n" +
            "down 4\n" +
            "down 2\n" +
            "down 7\n" +
            "up 5\n" +
            "up 5\n" +
            "down 1\n" +
            "forward 3\n" +
            "up 1\n" +
            "down 3\n" +
            "forward 9\n" +
            "forward 4\n" +
            "forward 7\n" +
            "down 4\n" +
            "down 4\n" +
            "down 2\n" +
            "forward 2\n" +
            "forward 1\n" +
            "forward 9\n" +
            "down 1\n" +
            "down 4\n" +
            "down 1\n" +
            "forward 4\n" +
            "up 8\n" +
            "forward 3\n" +
            "down 6\n" +
            "forward 5\n" +
            "forward 9\n" +
            "forward 1\n" +
            "up 8\n" +
            "down 7\n" +
            "down 8\n" +
            "forward 4\n" +
            "down 4\n" +
            "up 5\n" +
            "down 3\n" +
            "forward 3\n" +
            "down 6\n" +
            "down 1\n" +
            "down 9\n" +
            "forward 8\n" +
            "up 5\n" +
            "down 7\n" +
            "up 7\n" +
            "forward 3\n" +
            "up 5\n" +
            "up 7\n" +
            "down 4\n" +
            "up 2\n" +
            "down 2\n" +
            "down 8\n" +
            "up 6\n" +
            "down 4\n" +
            "up 1\n" +
            "down 8\n" +
            "down 4\n" +
            "forward 7\n" +
            "down 4\n" +
            "up 3\n" +
            "down 9\n" +
            "forward 3\n" +
            "up 4\n" +
            "up 1\n" +
            "up 5\n" +
            "down 4\n" +
            "forward 4\n" +
            "forward 4\n" +
            "down 2\n" +
            "down 3\n" +
            "down 4\n" +
            "forward 2\n" +
            "down 9\n" +
            "down 9\n" +
            "down 6\n" +
            "forward 5\n" +
            "forward 7\n" +
            "down 3\n" +
            "forward 2\n" +
            "up 8\n" +
            "down 6\n" +
            "down 8\n" +
            "down 2\n" +
            "up 9\n" +
            "down 1\n" +
            "forward 8\n" +
            "forward 1\n" +
            "forward 8\n" +
            "up 4\n" +
            "up 1\n" +
            "down 8\n" +
            "up 2\n" +
            "forward 5\n" +
            "down 3\n" +
            "forward 5\n" +
            "forward 4\n" +
            "forward 1\n" +
            "down 9\n" +
            "forward 2\n" +
            "forward 5\n" +
            "forward 4\n" +
            "forward 3\n" +
            "down 7\n" +
            "up 9\n" +
            "forward 7\n" +
            "up 8\n" +
            "forward 3\n" +
            "forward 3\n" +
            "down 5\n" +
            "forward 7\n" +
            "forward 5\n" +
            "down 4\n" +
            "forward 6\n" +
            "down 6\n" +
            "up 3\n" +
            "down 3\n" +
            "forward 7\n" +
            "forward 8\n" +
            "up 3\n" +
            "up 8\n" +
            "forward 8\n" +
            "up 4\n" +
            "forward 5\n" +
            "up 4\n" +
            "down 7\n" +
            "forward 4\n" +
            "down 8\n" +
            "down 6\n" +
            "forward 7\n" +
            "down 4\n" +
            "up 7\n" +
            "down 6\n" +
            "up 5\n" +
            "down 2\n" +
            "forward 7\n" +
            "down 7\n" +
            "up 3\n" +
            "up 3\n" +
            "down 3\n" +
            "down 5\n" +
            "forward 3\n" +
            "forward 5\n" +
            "forward 8\n" +
            "down 3\n" +
            "down 8\n" +
            "forward 3\n" +
            "down 1\n" +
            "forward 4\n" +
            "up 5\n" +
            "forward 8\n" +
            "up 1\n" +
            "up 4\n" +
            "down 4\n" +
            "forward 1\n" +
            "forward 6\n" +
            "up 7\n" +
            "up 1\n" +
            "up 7\n" +
            "down 5\n" +
            "forward 8\n" +
            "down 1\n" +
            "forward 1\n" +
            "forward 6\n" +
            "up 9\n" +
            "up 6\n" +
            "down 4\n" +
            "forward 5\n" +
            "down 1\n" +
            "forward 7\n" +
            "down 8\n" +
            "up 3\n" +
            "down 9\n" +
            "down 1\n" +
            "up 7\n" +
            "up 6\n" +
            "forward 8\n" +
            "down 9\n" +
            "down 4\n" +
            "forward 4\n" +
            "up 7\n" +
            "down 3\n" +
            "forward 5\n" +
            "forward 8\n" +
            "up 5\n" +
            "down 7\n" +
            "up 2\n" +
            "forward 3\n" +
            "forward 3\n" +
            "forward 4\n" +
            "down 1\n" +
            "forward 5\n" +
            "forward 7\n" +
            "up 7\n" +
            "forward 7\n" +
            "forward 1\n" +
            "forward 3\n" +
            "forward 9\n" +
            "down 3\n" +
            "forward 5\n" +
            "down 9\n" +
            "down 7\n" +
            "down 4\n" +
            "down 8\n" +
            "up 3\n" +
            "down 1\n" +
            "up 5\n" +
            "down 5\n" +
            "forward 2\n" +
            "down 6\n" +
            "down 5\n" +
            "forward 2\n" +
            "forward 6\n" +
            "down 6\n" +
            "up 6\n" +
            "down 8\n" +
            "up 1\n" +
            "forward 4\n" +
            "forward 2\n" +
            "forward 1\n" +
            "up 1\n" +
            "forward 5\n" +
            "forward 3\n" +
            "forward 7\n" +
            "down 9\n" +
            "forward 3\n" +
            "down 9\n" +
            "up 5\n" +
            "down 7\n" +
            "down 2\n" +
            "down 3\n" +
            "up 5\n" +
            "up 3\n" +
            "down 2\n" +
            "forward 4\n" +
            "forward 1\n" +
            "down 3\n" +
            "up 4\n" +
            "down 8\n" +
            "down 1\n" +
            "forward 6\n" +
            "down 3\n" +
            "forward 9\n" +
            "down 7\n" +
            "down 3\n" +
            "down 4\n" +
            "down 5\n" +
            "up 1\n" +
            "forward 8\n" +
            "forward 2\n" +
            "up 3\n" +
            "up 7\n" +
            "up 1\n" +
            "forward 3\n" +
            "forward 9\n" +
            "up 5\n" +
            "forward 6\n" +
            "down 8\n" +
            "down 9\n" +
            "down 5\n" +
            "forward 6\n" +
            "forward 3\n" +
            "forward 8\n" +
            "forward 7\n" +
            "forward 9\n" +
            "forward 2\n" +
            "up 9\n" +
            "forward 8\n" +
            "down 2\n" +
            "down 6\n" +
            "down 9\n" +
            "down 5\n" +
            "forward 1\n" +
            "down 7\n" +
            "forward 2\n" +
            "down 4\n" +
            "down 1\n" +
            "up 1\n" +
            "down 2\n" +
            "forward 5\n" +
            "forward 8\n" +
            "down 9\n" +
            "up 6\n" +
            "forward 8\n" +
            "forward 3\n" +
            "up 6\n" +
            "up 2\n" +
            "forward 8\n" +
            "down 8\n" +
            "up 1\n" +
            "down 6\n" +
            "down 2\n" +
            "down 6\n" +
            "forward 5\n" +
            "forward 6\n" +
            "down 4\n" +
            "forward 1\n" +
            "down 4\n" +
            "up 7\n" +
            "forward 4\n" +
            "up 1\n" +
            "forward 9\n" +
            "forward 7\n" +
            "up 3\n" +
            "down 7\n" +
            "down 4\n" +
            "forward 3\n" +
            "forward 8\n" +
            "forward 6\n" +
            "forward 6\n" +
            "up 1\n" +
            "up 2\n" +
            "up 8\n" +
            "down 7\n" +
            "forward 8\n" +
            "down 5\n" +
            "forward 6\n" +
            "down 1\n" +
            "down 9\n" +
            "down 2\n" +
            "forward 6\n" +
            "up 3\n" +
            "down 5\n" +
            "down 6\n" +
            "forward 1\n" +
            "forward 2\n" +
            "down 3\n" +
            "forward 8\n" +
            "forward 1\n" +
            "up 5\n" +
            "down 8\n" +
            "down 4\n" +
            "up 9\n" +
            "up 2\n" +
            "forward 7\n" +
            "forward 9\n" +
            "up 8\n" +
            "up 6\n" +
            "forward 1\n" +
            "down 7\n" +
            "up 1\n" +
            "down 3\n" +
            "forward 2\n" +
            "forward 3\n" +
            "down 3\n" +
            "down 2\n" +
            "forward 3\n" +
            "down 7\n" +
            "forward 3\n" +
            "forward 7\n" +
            "forward 7\n" +
            "down 8\n" +
            "down 4\n" +
            "forward 3\n" +
            "forward 4\n" +
            "down 7\n" +
            "down 9\n" +
            "down 4\n" +
            "down 2\n" +
            "forward 7\n" +
            "up 8\n" +
            "down 4\n" +
            "down 3\n" +
            "forward 9\n" +
            "down 5\n" +
            "up 6\n" +
            "up 2\n" +
            "down 5\n" +
            "down 6\n" +
            "forward 2\n" +
            "forward 8\n" +
            "down 1\n" +
            "forward 6\n" +
            "up 7\n" +
            "down 6\n" +
            "forward 4\n" +
            "down 2\n" +
            "down 5\n" +
            "down 9\n" +
            "forward 7\n" +
            "up 4\n" +
            "forward 9\n" +
            "up 7\n" +
            "down 4\n" +
            "down 6\n" +
            "up 9\n" +
            "forward 1\n" +
            "up 7\n" +
            "down 5\n" +
            "forward 3\n" +
            "forward 3\n" +
            "down 7\n" +
            "down 1\n" +
            "down 7\n" +
            "down 7\n" +
            "down 1\n" +
            "forward 8\n" +
            "forward 9\n" +
            "forward 8\n" +
            "down 9\n" +
            "down 8\n" +
            "down 5\n" +
            "down 3\n" +
            "forward 4\n" +
            "forward 1\n" +
            "down 1\n" +
            "forward 1\n" +
            "down 7\n" +
            "forward 7\n" +
            "forward 3\n" +
            "down 8\n" +
            "forward 3\n" +
            "forward 9\n" +
            "forward 8\n" +
            "down 7\n" +
            "forward 8\n" +
            "down 2\n" +
            "up 5\n" +
            "forward 7\n" +
            "forward 4\n" +
            "down 2\n" +
            "up 6\n" +
            "up 8\n" +
            "forward 7\n" +
            "down 9\n" +
            "up 3\n" +
            "forward 4\n" +
            "up 9\n" +
            "up 5\n" +
            "up 5\n" +
            "up 6\n" +
            "down 4\n" +
            "down 5\n" +
            "up 5\n" +
            "forward 7\n" +
            "forward 6\n" +
            "down 4\n" +
            "forward 5\n" +
            "forward 4\n" +
            "up 7\n" +
            "forward 8\n" +
            "down 2\n" +
            "forward 1\n" +
            "down 9\n" +
            "down 8\n" +
            "forward 7\n" +
            "down 7\n" +
            "down 1\n" +
            "forward 9\n" +
            "down 7\n" +
            "forward 6\n" +
            "down 2\n" +
            "up 9\n" +
            "forward 1\n" +
            "up 9\n" +
            "down 3\n" +
            "up 9\n" +
            "down 1\n" +
            "forward 1\n" +
            "down 1\n" +
            "up 6\n" +
            "down 8\n" +
            "up 2\n" +
            "down 3\n" +
            "forward 1\n" +
            "down 4\n" +
            "up 5\n" +
            "down 5\n" +
            "down 4\n" +
            "forward 5\n" +
            "forward 4\n" +
            "down 9\n" +
            "up 7\n" +
            "down 7\n" +
            "forward 7\n" +
            "forward 6\n" +
            "forward 8\n" +
            "down 8\n" +
            "forward 8\n" +
            "down 1\n" +
            "down 1\n" +
            "down 8\n" +
            "down 2\n" +
            "up 2\n" +
            "up 1\n" +
            "forward 5\n" +
            "down 1\n" +
            "up 5\n" +
            "up 2\n" +
            "down 6\n" +
            "up 8\n" +
            "forward 5\n" +
            "down 8\n" +
            "down 1\n" +
            "up 5\n" +
            "down 1\n" +
            "forward 4\n" +
            "down 6\n" +
            "down 4\n" +
            "forward 2\n" +
            "forward 2\n" +
            "down 1\n" +
            "up 4\n" +
            "up 8\n" +
            "down 6\n" +
            "down 2\n" +
            "forward 5\n" +
            "forward 8\n" +
            "forward 7\n" +
            "down 5\n" +
            "down 7\n" +
            "down 3\n" +
            "forward 6\n" +
            "down 3\n" +
            "down 3\n" +
            "forward 6\n" +
            "forward 6\n" +
            "forward 6\n" +
            "up 7\n" +
            "forward 1\n" +
            "down 5\n" +
            "down 2\n" +
            "up 8\n" +
            "forward 6\n" +
            "down 7\n" +
            "down 6\n" +
            "forward 1\n" +
            "up 5\n" +
            "down 4\n" +
            "up 9\n" +
            "forward 3\n" +
            "up 3\n" +
            "forward 9\n" +
            "forward 9\n" +
            "forward 7\n" +
            "forward 5\n" +
            "down 9\n" +
            "forward 1\n" +
            "forward 6\n" +
            "up 8\n" +
            "down 7\n" +
            "forward 9\n" +
            "forward 5\n" +
            "up 4\n" +
            "down 8\n" +
            "forward 8\n" +
            "forward 4\n" +
            "down 9\n" +
            "up 2\n" +
            "forward 5\n" +
            "forward 8\n" +
            "down 8\n" +
            "down 9\n" +
            "down 9\n" +
            "forward 4\n" +
            "forward 8\n" +
            "down 5\n" +
            "down 5\n" +
            "forward 5\n" +
            "forward 5\n" +
            "up 9\n" +
            "up 7\n" +
            "forward 3\n" +
            "up 4\n" +
            "down 8\n" +
            "up 6\n" +
            "up 6\n" +
            "down 4\n" +
            "down 3\n" +
            "forward 2\n" +
            "forward 9\n" +
            "down 4\n" +
            "down 2\n" +
            "forward 4\n" +
            "up 9\n" +
            "forward 1\n" +
            "down 8\n" +
            "down 9\n" +
            "down 9\n" +
            "down 3\n" +
            "forward 1\n" +
            "down 5\n" +
            "up 9\n" +
            "forward 6\n" +
            "up 4\n" +
            "forward 2\n" +
            "forward 2\n" +
            "forward 4\n" +
            "down 9\n" +
            "up 5\n" +
            "up 1\n" +
            "down 6\n" +
            "forward 7\n" +
            "down 8\n" +
            "forward 4\n" +
            "forward 9\n" +
            "up 9\n" +
            "up 4\n" +
            "down 5\n" +
            "down 3\n" +
            "forward 2\n" +
            "down 8\n" +
            "down 6\n" +
            "forward 3\n" +
            "down 2\n" +
            "forward 6\n" +
            "up 2\n" +
            "forward 6\n" +
            "down 7\n" +
            "up 4\n" +
            "forward 1\n" +
            "forward 4\n" +
            "up 4\n" +
            "forward 6\n" +
            "forward 8\n" +
            "down 7\n" +
            "down 6\n" +
            "up 7\n" +
            "down 2\n" +
            "down 4\n" +
            "down 5\n" +
            "forward 1\n" +
            "up 4\n" +
            "forward 8\n" +
            "forward 6\n" +
            "down 8\n" +
            "up 5\n" +
            "up 2\n" +
            "up 9\n" +
            "up 5\n" +
            "forward 6\n" +
            "down 4\n" +
            "up 3\n" +
            "down 8\n" +
            "down 6\n" +
            "down 2\n" +
            "up 3\n" +
            "up 5\n" +
            "down 1\n" +
            "forward 9\n" +
            "up 8\n" +
            "up 2\n" +
            "down 3\n" +
            "forward 6\n" +
            "down 1\n" +
            "forward 5\n" +
            "down 3\n" +
            "up 1\n" +
            "up 2\n" +
            "down 5\n" +
            "down 7\n" +
            "forward 8\n" +
            "down 8\n" +
            "up 9\n" +
            "forward 3\n" +
            "down 8\n" +
            "down 8\n" +
            "forward 1\n" +
            "down 4\n" +
            "down 4\n" +
            "forward 3\n" +
            "up 6\n" +
            "down 3\n" +
            "down 7\n" +
            "down 7\n" +
            "up 1\n" +
            "forward 3\n" +
            "forward 2").split("\n")).collect(Collectors.toList());

    public static void main(String[] args) {
        part1();
        part2();
    }

    static void part1() {
        int x = 0;
        int y = 0;

        for (String s : input) {
            String[] splitString = s.split(" ");
            String command = splitString[0];
            int number = Integer.parseInt(splitString[1]);

            switch (command) {
                case "forward" -> x += number;
                case "down" -> y += number;
                case "up" -> y -= number;
            }
        }

        System.out.println(x * y);
    }

    static void part2() {
        int x = 0;
        int y = 0;
        int aim = 0;
        for (String s : input) {
            String[] splitString = s.split(" ");
            String command = splitString[0];
            int number = Integer.parseInt(splitString[1]);

            switch (command) {
                case "forward" -> {
                    x += number;
                    y += aim * number;
                }
                case "down" -> aim += number;
                case "up" -> aim -= number;
            }
        }

        System.out.println(x * y);
    }
}
