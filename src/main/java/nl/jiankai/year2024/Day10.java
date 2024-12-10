package nl.jiankai.year2024;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Day10 {
    public static void main(String[] args) {
        part2();
    }

    private static void part1() {
        List<String[]> grid = Arrays.stream(input.split("\n")).map(s -> s.split("")).toList();
        int ans = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length; j++) {
                if (grid.get(i)[j].equals("0")) {
                    ans += bfs(grid, j, i);
                }
            }
        }

        System.out.println(ans);
    }

    private static void part2() {
        List<String[]> grid = Arrays.stream(input.split("\n")).map(s -> s.split("")).toList();
        Set<Pos2> peaks = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length; j++) {
                if (grid.get(i)[j].equals("0")) {
                    ans += bfs2(peaks, grid, j, i);
                }
            }
        }

        System.out.println(ans);
    }

    private static int bfs2(Set<Pos2> peaks, List<String[]> grid, int x, int y) {
        if (grid.get(y)[x].equals("9")) {
            if (peaks.contains(new Pos2(x, y))) {
                return 0;
            } else {
                return 1;
            }
        }
        int total = 0;
        int val = Integer.parseInt(grid.get(y)[x]);

        if (x > 0 && Integer.parseInt(grid.get(y)[x - 1]) - val == 1) {
            total += bfs2(peaks, grid, x - 1, y);
        }

        if (x < grid.size() - 1 && Integer.parseInt(grid.get(y)[x + 1]) - val == 1) {
            total += bfs2(peaks, grid, x + 1, y);
        }

        if (y > 0 && Integer.parseInt(grid.get(y - 1)[x]) - val == 1) {
            total += bfs2(peaks, grid, x, y - 1);
        }

        if (y < grid.size() - 1 && Integer.parseInt(grid.get(y + 1)[x]) - val == 1) {
            total += bfs2(peaks, grid, x, y + 1);
        }

        return total;
    }


    private static int bfs(List<String[]> grid, int x, int y) {
        if (grid.get(y)[x].equals("9")) {
            return 1;
        }

        int total = 0;
        int val = Integer.parseInt(grid.get(y)[x]);

        if (x > 0 && Integer.parseInt(grid.get(y)[x - 1]) - val == 1) {
            total += bfs(grid, x - 1, y);
        }

        if (x < grid.size() - 1 && Integer.parseInt(grid.get(y)[x + 1]) - val == 1) {
            total += bfs(grid, x + 1, y);
        }

        if (y > 0 && Integer.parseInt(grid.get(y - 1)[x]) - val == 1) {
            total += bfs(grid, x, y - 1);
        }

        if (y < grid.size() - 1 && Integer.parseInt(grid.get(y + 1)[x]) - val == 1) {
            total += bfs(grid, x, y + 1);
        }

        return total;
    }

    private record Pos2(int x, int y) {

    }

    private record Pos(int x, int y, int xStart, int yStart) {

    }

    private static String input = """
            901403454308767601987430010102103430787676
            812312567219458912376541023411212321096787
            765403498012307433489432196520303234585898
            012354321087216524570343787434454100674301
            985467891096987019601234378976569981001210
            876654102345106508710765234789678972343454
            798783287765278710789820105678710169858763
            687690196894369821890112344589801258769012
            501543285210152152721201453078987340150103
            432457894101043043630328762101456498201232
            870326543232032154549419234652343567398341
            961210012343129069608500165765432985437650
            054301456953238778217671876893211076126789
            123012387869345632347889956544509089005491
            128723498778734101256970987832678179012310
            039614595654187214378921078981083238768723
            340507680343096785561434563470198740059654
            651408971252125896450001412563267651145098
            762310564561034587321112303214107892230127
            891023453478987878543203474905896543451936
            678921962101216969458914985876708712767845
            567630879870305456367325676765219603856696
            654544567765412343210232110894334564943787
            783203498894301210321143029889123765830654
            890112985435213456787054334778010894321003
            901209876120102365098765245667654784321212
            892100125009871074109670123454743065210012
            763119834312568983232189812303892178756763
            654098701233457654983074505412789109349854
            120145610145012523474563676545630201201340
            034234543296543210565012985654321347652201
            543007665487012365034876501745610458943102
            632118978329110874128989432891234367812983
            789327659418723923567876541010765298103894
            879454341507654010430765430199804105412765
            988761030676589012321650321783219876545630
            896902321585438543456761230654323401454321
            787813490492127654349854345013210562367212
            076524582341013434234981016724505678498101
            123433671034565521187832109834694989654342
            589652180123877610096543258943783878701233
            676543091012988987101234567652102107212344
            """;

}
