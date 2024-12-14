package nl.jiankai.year2024;


//import org.apache.commons.math3.linear.*;

import java.math.BigDecimal;
import java.util.*;

public class Day13 {
    public static void main(String[] args) {
        part2();
    }

    private static void part1() {
        List<String> games = Arrays.stream(input.split("\n\n")).toList();
        long ans = games.parallelStream().map(game -> {
                    String[] parts = game.split("\n");
                    String[] a = parts[0]
                            .replace("Button A: ", "")
                            .replace("X+", "")
                            .replace("Y+", "").split(", ");
                    String[] b = parts[1]
                            .replace("Button B: ", "")
                            .replace("X+", "")
                            .replace("Y+", "").split(", ");
                    String[] prize = parts[2]
                            .replace("Prize: ", "")
                            .replace("X=", "")
                            .replace("Y=", "").split(", ");
                    long lowest = lowest(
                            Long.parseLong(a[0]),
                            Long.parseLong(a[1]),
                            Long.parseLong(b[0]),
                            Long.parseLong(b[1]),
                            Long.parseLong(prize[0]),
                            Long.parseLong(prize[1])
                    );

                    System.out.println(lowest);
                    return lowest;
                })
                .mapToLong(Long::longValue).filter(val -> val != Long.MAX_VALUE)
                .sum();

        System.out.println(ans);
    }

    private static long lowest(long ax, long ay, long bx, long by, long px, long py) {
        LinkedList<Perm> perms = new LinkedList<>();
        Map<Pos, Long> lowest = new HashMap<>();
        LinkedList<Perm> reached = new LinkedList<>();
        perms.add(new Perm(0, 0, 0));

        while (reached.isEmpty()) {
            Perm perm = perms.poll();
            if (perm.x == px && perm.y == py) {
                reached.add(perm);
            }
            if (lowest.containsKey(new Pos(perm.x, perm.y)) && lowest.get(new Pos(perm.x, perm.y)) <= perm.steps) {
                continue;
            }
            lowest.put(new Pos(perm.x, perm.y), perm.steps);
            if (perm.x < px || perm.y < py) {
                perms.add(new Perm(perm.x + ax, perm.y + ay, perm.steps + 3));
                perms.add(new Perm(perm.x + bx, perm.y + by, perm.steps + 1));
            } else {
                break;
            }
        }


        return reached
                .stream()
                .filter(perm -> perm.x == px && perm.y == py)
                .min(Comparator.comparingLong(p -> p.steps))
                .map(Perm::steps)
                .orElse(Long.MAX_VALUE);
    }

    private static void part2() {
        List<String> games = Arrays.stream(input.split("\n\n")).toList();
        long ans = games.stream().map(game -> {
                    String[] parts = game.split("\n");
                    String[] a = parts[0]
                            .replace("Button A: ", "")
                            .replace("X+", "")
                            .replace("Y+", "").split(", ");
                    String[] b = parts[1]
                            .replace("Button B: ", "")
                            .replace("X+", "")
                            .replace("Y+", "").split(", ");
                    String[] prize = parts[2]
                            .replace("Prize: ", "")
                            .replace("X=", "")
                            .replace("Y=", "").split(", ");
                    long lowest = lowest2(
                            Long.parseLong(a[0]),
                            Long.parseLong(a[1]),
                            Long.parseLong(b[0]),
                            Long.parseLong(b[1]),
                            Long.parseLong(prize[0])+10000000000000L,
                            Long.parseLong(prize[1])+10000000000000L
                    );

                    System.out.println(lowest);
                    return lowest;
                })
                .mapToLong(Long::longValue).filter(val -> val != Long.MAX_VALUE)
                .sum();

        System.out.println(ans);
    }

    private static long lowest2(long ax, long ay, long bx, long by, long px, long py) {
        double[][] coefficients = {
                {ax, bx},
                {ay, by}
        };

        double[] constants = {px, py};

//        RealMatrix matrix = new Array2DRowRealMatrix(coefficients, false);
//        RealVector vector = new ArrayRealVector(constants, false);
//
//        DecompositionSolver solver = new LUDecomposition(matrix).getSolver();
//        RealVector solution = solver.solve(vector);
//        var n = solution.getEntry(0);
//        var m = solution.getEntry(1);
//
//        if (Math.abs(n - Math.round(n)) < 1e-4d && Math.abs(m - Math.round(m)) < 1e-4d  // integer solution!
//                && Math.round(n) <= 10000000000000L && Math.round(m) <= 10000000000000L) {
//            return Math.round(n) * 3 + Math.round(m);
//        }

        return Long.MAX_VALUE;
    }


    private record Pos(long x, long y) {
    }

    private record Perm(long x, long y, long steps) {
    }

    private static String input = """
Button A: X+94, Y+34
Button B: X+22, Y+67
Prize: X=10000000008400, Y=10000000005400

Button A: X+26, Y+66
Button B: X+67, Y+21
Prize: X=10000000012748, Y=10000000012176

Button A: X+17, Y+86
Button B: X+84, Y+37
Prize: X=10000000007870, Y=10000000006450

Button A: X+69, Y+23
Button B: X+27, Y+71
Prize: X=10000000018641, Y=10000000010279""";

}
